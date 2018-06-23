package com.newlight77.admin.mapper;

import com.newlight77.admin.model.User;
import com.newlight77.admin.neo4j.UserEntity;

public class UserMapper {

  public static User to(UserEntity entity) {
    return User.builder()
        .firstname(entity.getFirstname())
        .lastname(entity.getLastname())
        .username(entity.getUsername()).build();
  }

  public static UserEntity from(User user) {
    return UserEntity.builder()
        .firstname(user.getFirstname())
        .lastname(user.getLastname())
        .username(user.getUsername())
        .build();
  }
}
