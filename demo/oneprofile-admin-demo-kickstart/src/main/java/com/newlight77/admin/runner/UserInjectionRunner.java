package com.newlight77.admin.runner;

import com.newlight77.admin.neo4j.UserEntity;
import com.newlight77.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class UserInjectionRunner implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(final String... args) throws Exception {
    UserEntity user = UserEntity.builder()
            .lastname("To")
            .firstname("Kong")
            .username("newlight77@gmail.com")
            .build();
    userRepository.save(user);
  }
}
