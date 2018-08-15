package com.newlight77.admin.runner;

import com.newlight77.admin.neo4j.*;
import com.newlight77.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;
import java.util.HashSet;

public class UserInjectionRunner implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(final String... args) throws Exception {
    UserEntity user = UserEntity.builder()
            .lastname("To")
            .firstname("Kong")
            .username("newlight77@gmail.com")
            .hasRoles(new HashSet<>())
            .build();

    RoleEntity role = RoleEntity.builder()
            .name("admin")
            .hasRoles(new HashSet<>())
            .hasRights(new HashSet<>())
            .build();

    RightEntity right1 = RightEntity.builder()
            .primary("newlight77@gmail.com")
            .secondary("UserController")
            .rights(new HashSet<>(Arrays.asList("ADMIN_WRITE", "ADMIN_READ", "ADMIN_DELETE")))
            .hasRights(new HashSet<>())
            .build();
    RightEntity right2 = RightEntity.builder()
            .primary("newlight77@gmail.com")
            .secondary("RoleController")
            .rights(new HashSet<>(Arrays.asList("ADMIN_WRITE", "ADMIN_READ", "ADMIN_DELETE")))
            .hasRights(new HashSet<>())
            .build();

    HasRoleRelation hasRoleRelation = HasRoleRelation.builder().user(user).role(role).build();
    user.getHasRoles().add(hasRoleRelation);
//    role.getHasRoles().add(hasRoleRelation);

    HasRightRelation hasRightRelation1 = HasRightRelation.builder().role(role).right(right1).build();
    HasRightRelation hasRightRelation2 = HasRightRelation.builder().role(role).right(right2).build();
    role.getHasRights().addAll(Arrays.asList(hasRightRelation1, hasRightRelation2));

//    right1.getHasRights().add(hasRightRelation1);
//    right2.getHasRights().add(hasRightRelation2);

    userRepository.save(user);
  }
}
