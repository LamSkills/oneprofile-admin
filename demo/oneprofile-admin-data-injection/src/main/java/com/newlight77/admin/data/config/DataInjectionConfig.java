package com.newlight77.admin.data.config;

import com.newlight77.admin.data.runner.UserInjectionRunner;
import com.newlight77.admin.data.runner.UserJsonInjectionRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@EnableNeo4jRepositories(basePackages = {"com.newlight77.admin.repository" })
@EntityScan(basePackages = "com.newlight77.admin.neo4j")
public class DataInjectionConfig {

  @Bean
  CommandLineRunner userInjectionRunner() {
    return new UserInjectionRunner();
  }

}
