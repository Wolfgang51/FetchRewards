package com.example.fetchrewards;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FetchRewardsApplication {

  private static final Logger logger = LoggerFactory.getLogger(FetchRewardsApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(FetchRewardsApplication.class, args);
  }

  @Bean
  CommandLineRunner initDatabase(TransactionRepository repository) {

    return args -> {
//			logger.info("Preloading " + repository.save(new Transaction("oldest", 1000, new Date())));
//			logger.info("Preloading " + repository.save(new Transaction("older", 1000, new Date())));
//			logger.info("Preloading " + repository.save(new Transaction("new", 1000, new Date())));
    };

  }
}
