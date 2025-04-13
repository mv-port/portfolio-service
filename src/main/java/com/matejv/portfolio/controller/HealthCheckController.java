package com.matejv.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class HealthCheckController {

  @Autowired
  private DataSource dataSource;

  @GetMapping("/db-health")
  public String checkDbConnection() {
    try (Connection connection = dataSource.getConnection()) {
      if (connection.isValid(2)) {
        return "OK";
      } else {
        return "Database connection is not valid";
      }
    } catch (Exception e) {
      return "Error: " + e.getMessage();
    }
  }
}
