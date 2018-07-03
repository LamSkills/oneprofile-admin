package com.newlight77.admin.mapper;

import com.newlight77.admin.model.UserDto;
import com.newlight77.admin.neo4j.UserEntity;

import java.util.stream.Collectors;

public class UserMapper {

  public static UserDto to(UserEntity entity) {
    return UserDto.builder()
            .firstname(entity.getFirstname())
            .lastname(entity.getLastname())
            .username(entity.getUsername())
            .accounts(entity.getAccounts().stream().map(AccountMapper::to).collect(Collectors.toSet()))
            .build();
  }

  public static UserEntity from(UserDto dto) {
    return UserEntity.builder()
            .firstname(dto.getFirstname())
            .lastname(dto.getLastname())
            .username(dto.getUsername())
            .accounts(dto.getAccounts().stream().map(AccountMapper::from).collect(Collectors.toSet()))
            .build();
  }
}
