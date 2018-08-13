package com.newlight77.admin;

import com.newlight77.admin.neo4j.*;
import com.newlight77.admin.repository.UserRepository;
import com.newlight77.right.model.Right;
import org.mockito.internal.util.collections.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

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
//            .roles(Sets.newSet())
            .hasRoles(Sets.newSet())
            .build();

    RoleEntity role = RoleEntity.builder()
            .name("admin")
//            .user(user)
//            .rights(Sets.newSet())
            .hasRoles(Sets.newSet())
            .hasRights(Sets.newSet())
            .build();

    RightEntity right1 = RightEntity.builder()
            .primary("newlight77@gmail.com")
            .secondary("UserController")
            .rights(Sets.newSet(Right.ADMIN_WRITE, Right.ADMIN_READ, Right.ADMIN_DELETE))
            .hasRights(Sets.newSet())
            .build();
    RightEntity right2 = RightEntity.builder()
            .primary("newlight77@gmail.com")
            .secondary("RoleController")
            .rights(Sets.newSet(Right.ADMIN_WRITE, Right.ADMIN_READ, Right.ADMIN_DELETE))
            .hasRights(Sets.newSet())
            .build();
    RightEntity right3 = RightEntity.builder()
            .primary("newlight77@gmail.com")
            .secondary("RightController")
            .rights(Sets.newSet(Right.ADMIN_WRITE, Right.ADMIN_READ, Right.ADMIN_DELETE))
            .hasRights(Sets.newSet())
            .build();

    HasRoleRelation hasRoleRelation = HasRoleRelation.builder().user(user).role(role).build();

    HasRightRelation hasRightRelation1 = HasRightRelation.builder().role(role).right(right1).build();
    HasRightRelation hasRightRelation2 = HasRightRelation.builder().role(role).right(right2).build();
    HasRightRelation hasRightRelation3 = HasRightRelation.builder().role(role).right(right3).build();

    user.getHasRoles().add(hasRoleRelation);
//    user.getRoles().add(role);

//    role.getRights().addAll(Sets.newSet(right1, right2, right3));
    role.getHasRoles().add(hasRoleRelation);
    role.getHasRights().addAll(Sets.newSet(hasRightRelation1,hasRightRelation2, hasRightRelation3));

    right1.getHasRights().add(hasRightRelation1);
    right2.getHasRights().add(hasRightRelation2);
    right3.getHasRights().add(hasRightRelation3);

    userRepository.save(user);
  }
}
