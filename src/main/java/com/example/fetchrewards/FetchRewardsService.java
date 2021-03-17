package com.example.fetchrewards;

import java.util.List;

public interface FetchRewardsService {

  List<Payer> spendPoints(Points points);

  Transaction addPoints(Transaction newTransaction);

  List<Transaction> getAllTransactions();

  List<Payer> getAllPayerBalances();
}
