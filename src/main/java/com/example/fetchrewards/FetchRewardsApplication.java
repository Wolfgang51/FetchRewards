package com.example.fetchrewards;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example.fetchrewards")
public class FetchRewardsApplication {

  private static final Logger logger = LoggerFactory.getLogger(FetchRewardsApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(FetchRewardsApplication.class, args);
  }
}
