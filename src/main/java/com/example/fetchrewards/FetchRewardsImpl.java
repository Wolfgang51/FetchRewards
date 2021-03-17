package com.example.fetchrewards;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchRewardsImpl implements FetchRewardsService {

  @Autowired
  private TransactionRepository transactionRepository;
  @Autowired
  private PayerRepository payerRepository;

  @Override
  public List<Payer> spendPoints(Points points) {

    List<Transaction> sortedTransactionsAscByDate = transactionRepository.getMostRecentPoints();
    int pointsToSubtract = points.getPoints();
    SubtractedPointsHelper sp = new SubtractedPointsHelper();

    for (Transaction transaction : sortedTransactionsAscByDate) {

      if (pointsToSubtract == 0) {
        break;
      } else if (transaction.getPoints() < pointsToSubtract) {
        pointsToSubtract -= transaction.getPoints();
        sp.subtractPoints(transaction.getPayer(), transaction.getPoints());
        transactionRepository.removeTransaction(transaction.getId());
      } else {
        int updatePoints = transaction.getPoints() - pointsToSubtract;
        sp.subtractPoints(transaction.getPayer(), pointsToSubtract);
        transactionRepository.updateTransactionsPoints(updatePoints, transaction.getId());
        pointsToSubtract = 0;
      }
    }

    subtractPointsFromPayerBalances(sp);

    return sp.getSubtractedPointsForPayers();
  }

  private void subtractPointsFromPayerBalances(SubtractedPointsHelper sp) {
    for (Map.Entry<String, Integer> entry : sp.getSubtractedPoints().entrySet()) {
      payerRepository.updatePayersBalance(entry.getKey(), entry.getValue());
    }
  }

  @Override
  public Transaction addPoints(Transaction newTransaction) {

    if (!payerRepository.findPayer(newTransaction.getPayer()).isEmpty()) {
      payerRepository.updatePayersBalance(newTransaction.getPayer(), newTransaction.getPoints());
    } else {
      payerRepository.save(new Payer(newTransaction.getPayer(), newTransaction.getPoints()));
    }

    return transactionRepository.save(newTransaction);
  }

  @Override
  public List<Transaction> getAllTransactions() {
    return transactionRepository.findAll();
  }

  @Override
  public List<Payer> getAllPayerBalances() {
    return payerRepository.findAll();
  }
}
