package com.newlight77.admin.data.config;

import com.newlight77.admin.data.runner.InvalidUserEntityInjectionRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@EnableNeo4jRepositories(basePackages = {
    "com.newlight77.admin.data.injection.repository" })
@EntityScan(basePackages = "com.newlight77.data.admin.entity.user.neo4j")
public class DataInjectionConfig {

//  @Bean
//  CommandLineRunner userInjectionRunner() {
//    return new UserInjectionRunner();
//  }

  @Bean
  CommandLineRunner invalidUserEntityInjectionRunner() {
    return new InvalidUserEntityInjectionRunner();
  }

//  @Bean
//  CommandLineRunner userJsonInjectionRunner() {
//    return new UserJsonInjectionRunner();
//  }

}
