package com.newlight77.admin.config;

import com.newlight77.admin.UserInjectionRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
public class DataInjectionConfig {

  @Bean
  CommandLineRunner userInjectionRunner() {
    return new UserInjectionRunner();
  }

}
