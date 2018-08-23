package com.newlight77.admin.config;

import com.newlight77.admin.Neo4jCypherRunner;
import com.newlight77.admin.UserInjectionRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:neo4j.properties")
public class DataInjectionConfig {

  @Value("${spring.data.neo4j.uri}")
  String uri;
  @Value("${spring.data.neo4j.username}")
  String user;
  @Value("${spring.data.neo4j.password}")
  String password;

  @Bean
  CommandLineRunner userInjectionRunner() {
    return new UserInjectionRunner();
  }

  @Bean
  CommandLineRunner neo4jSchemaInitializer() { return new Neo4jCypherRunner(uri, user, password);}
}
