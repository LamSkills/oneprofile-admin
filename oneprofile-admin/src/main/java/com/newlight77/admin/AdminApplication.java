package com.newlight77.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.newlight77")
public class AdminApplication {

  private final Logger LOGGER = LoggerFactory.getLogger(AdminApplication.class);

  public static void main(String[] args) throws Exception {
    SpringApplication.run(AdminApplication.class, args);
  }
}
