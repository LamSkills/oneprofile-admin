package com.newlight77.admin.config;

import com.newlight77.bhavio.core.repository.user.neo4j.AccountRepository;
import com.newlight77.bhavio.core.repository.user.neo4j.RoleRepository;
import com.newlight77.bhavio.core.repository.user.neo4j.UserRepository;
import com.newlight77.bhavio.core.service.AccountService;
import com.newlight77.bhavio.core.service.RoleService;
import com.newlight77.bhavio.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@EnableNeo4jRepositories(basePackages = { "com.bhavio.core.repository.user.neo4j" })
@EntityScan(basePackages = "com.bhavio.core.entity.user.neo4j")
public class UserAccountConfig {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private UserRepository userRepository;

  @Bean
  public AccountService accountRepository() {
    return new AccountService(accountRepository);
  }
  @Bean
  public RoleService roleRepository() {
    return new RoleService(roleRepository);
  }

  @Bean
  public UserService userService() {
    return new UserService(userRepository);
  }
}
