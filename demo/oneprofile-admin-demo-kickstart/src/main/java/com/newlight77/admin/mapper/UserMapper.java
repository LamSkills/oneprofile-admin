package com.newlight77.admin.mapper;

import com.newlight77.admin.neo4j.UserEntity;
import com.newlight77.admin.model.UserDto;

public class UserMapper {

  public static UserDto to(UserEntity entity) {
    return UserDto.builder()
            .firstname(entity.getFirstname())
            .lastname(entity.getLastname())
            .username(entity.getUsername())
            .build();
  }

  public static UserEntity from(UserDto dto) {
    return UserEntity.builder()
            .firstname(dto.getFirstname())
            .lastname(dto.getLastname())
            .username(dto.getUsername())
            .build();
  }
}
