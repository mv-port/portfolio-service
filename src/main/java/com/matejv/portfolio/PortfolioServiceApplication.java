package com.matejv.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class PortfolioServiceApplication {
  private static final Logger logger = LoggerFactory.getLogger(PortfolioServiceApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(PortfolioServiceApplication.class, args);
    logger.info("Portfolio Service Application started successfully.");
  }

}
