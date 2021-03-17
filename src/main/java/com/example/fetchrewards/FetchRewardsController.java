package com.example.fetchrewards;

import com.example.fetchrewards.models.Payer;
import com.example.fetchrewards.models.Points;
import com.example.fetchrewards.models.Transaction;
import com.example.fetchrewards.service.internal.FetchRewardsImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FetchRewardsController {

  @Autowired
  private FetchRewardsImpl fetchRewardsService;

  @GetMapping("/transactions")
  List<Transaction> allTransactions() {
    return fetchRewardsService.getAllTransactions();
  }

  @GetMapping("/balances")
  List<Payer> allPayerBalances() {
    return fetchRewardsService.getAllPayerBalances();
  }

  @PostMapping(path = "/transaction", consumes = "application/json", produces = "application/json")
  Transaction newTransaction(@RequestBody Transaction newTransaction) {
    return fetchRewardsService.addPoints(newTransaction);
  }

  @PostMapping(path = "/points", consumes = "application/json", produces = "application/json")
  List<Payer> spendPoints(@RequestBody Points points) {
    return fetchRewardsService.spendPoints(points);
  }
}
