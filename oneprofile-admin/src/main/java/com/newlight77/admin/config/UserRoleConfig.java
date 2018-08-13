package com.newlight77.admin.config;

import com.newlight77.admin.repository.RightRepository;
import com.newlight77.admin.repository.UserRepository;
import com.newlight77.admin.service.RightService;
import com.newlight77.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@EnableNeo4jRepositories(basePackages = { "com.newlight77.admin.repository" })
@EntityScan(basePackages = "com.newlight77.admin.neo4j")
public class UserRoleConfig {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RightRepository rightRepository;

  @Bean
  public UserService userService() {
    return new UserService(userRepository);
  }

  @Bean
  public RightService rightService() { return new RightService(rightRepository); }
}
