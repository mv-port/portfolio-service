package com.matejv.portfolio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioController {

  @GetMapping("/portfolio/health")
  public String health() {
    return "OK";
  }
}
