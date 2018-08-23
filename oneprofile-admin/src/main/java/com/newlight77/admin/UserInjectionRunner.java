package com.newlight77.admin;

import com.newlight77.admin.neo4j.*;
import com.newlight77.admin.repository.UserRepository;
import com.newlight77.right.model.Right;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;
import java.util.HashSet;

public class UserInjectionRunner implements CommandLineRunner {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserInjectionRunner.class);

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

    RoleEntity ownerRole = RoleEntity.builder()
            .name("owner")
            .hasRoles(new HashSet<>())
            .hasRights(new HashSet<>())
            .build();

    RoleEntity adminRole = RoleEntity.builder()
            .name("admin")
            .hasRoles(new HashSet<>())
            .hasRights(new HashSet<>())
            .build();

    RightEntity ownerRightOnUser = RightEntity.builder()
            .primary("newlight77@gmail.com")
            .secondary("UserController")
            .rights(new HashSet<>(Arrays.asList(Right.OWNER)))
            .hasRights(new HashSet<>())
            .build();

    RightEntity adminRightOnUsers = RightEntity.builder()
            .primary("newlight77@gmail.com")
            .secondary("UserController")
            .rights(new HashSet<>(Arrays.asList(Right.ADMIN_WRITE, Right.ADMIN_READ, Right.ADMIN_DELETE)))
            .hasRights(new HashSet<>())
            .build();

    RightEntity adminRightOnRoles = RightEntity.builder()
            .primary("newlight77@gmail.com")
            .secondary("RoleController")
            .rights(new HashSet<>(Arrays.asList(Right.ADMIN_WRITE, Right.ADMIN_READ, Right.ADMIN_DELETE)))
            .hasRights(new HashSet<>())
            .build();
    RightEntity adminRightOnRights = RightEntity.builder()
            .primary("newlight77@gmail.com")
            .secondary("RightController")
            .rights(new HashSet<>(Arrays.asList(Right.ADMIN_WRITE, Right.ADMIN_READ, Right.ADMIN_DELETE)))
            .hasRights(new HashSet<>())
            .build();

    HasRoleRelation hasRoleRelationOwner = HasRoleRelation.builder().user(user).role(ownerRole).build();
    HasRoleRelation hasRoleRelationAdmin = HasRoleRelation.builder().user(user).role(adminRole).build();
    user.getHasRoles().add(hasRoleRelationOwner);
    user.getHasRoles().add(hasRoleRelationAdmin);
//    role.getHasRoles().add(hasRoleRelation);

    HasRightRelation hasRightRelation1 = HasRightRelation.builder().role(ownerRole).right(ownerRightOnUser).build();
    HasRightRelation hasRightRelation2 = HasRightRelation.builder().role(adminRole).right(adminRightOnUsers).build();
    HasRightRelation hasRightRelation3 = HasRightRelation.builder().role(adminRole).right(adminRightOnRoles).build();
    HasRightRelation hasRightRelation4 = HasRightRelation.builder().role(adminRole).right(adminRightOnRights).build();
    ownerRole.getHasRights().add(hasRightRelation1);
    adminRole.getHasRights().add(hasRightRelation2);
    adminRole.getHasRights().add(hasRightRelation3);
    adminRole.getHasRights().add(hasRightRelation4);

//    right1.getHasRights().add(hasRightRelation1);
//    right2.getHasRights().add(hasRightRelation2);
//    right3.getHasRights().add(hasRightRelation3);

    try {
      userRepository.save(user);
    } catch (Exception ex) {
      LOGGER.error("An error occurred while trying to create user. It might already exist.");
    }
  }
}
