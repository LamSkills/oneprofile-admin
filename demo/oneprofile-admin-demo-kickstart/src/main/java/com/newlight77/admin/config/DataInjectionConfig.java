package com.newlight77.admin.config;

import com.newlight77.admin.runner.UserInjectionRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInjectionConfig {

  @Bean
  CommandLineRunner userInjectionRunner() {
    return new UserInjectionRunner();
  }

}
