package com.matejv.portfolio.controller;

import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

  @GetMapping("/api/health")
  public Map<String, Object> health() {
    Map<String, Object> health = new HashMap<>();
    health.put("status", "UP");
    health.put("message", "Service is running");
    return health;
  }
}
