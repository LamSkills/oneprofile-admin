package com.newlight77.admin.data.runner;

import com.newlight77.admin.neo4j.RightEntity;
import com.newlight77.admin.repository.UserRepository;
import com.newlight77.admin.neo4j.AccountEntity;
import com.newlight77.admin.neo4j.RoleEntity;
import com.newlight77.admin.neo4j.UserEntity;
import com.newlight77.right.model.Right;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spark_project.guava.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class UserInjectionRunner implements CommandLineRunner {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserInjectionRunner.class);

  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(final String... args) throws Exception {
    RightEntity right = RightEntity.builder()
            .primary("admin_user")
            .secondary("admin_resource")
            .rights(Sets.newHashSet(Right.ADMIN_WRITE))
            .build();
    RoleEntity role = RoleEntity.builder()
        .name("admin")
        .rights(Sets.newHashSet(right))
        .build();
    AccountEntity account = AccountEntity.builder()
        .name("default")
        .roles(Sets.newHashSet(role))
        .build();
    UserEntity entity = UserEntity.builder()
        .lastname("To")
        .firstname("Kong")
        .username("newlight77@gmail.com")
        .accounts(Sets.newHashSet(account))
        .build();
    userRepository.save(entity);
  }
}
