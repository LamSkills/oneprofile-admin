package com.newlight77.admin.mapper;

import com.newlight77.admin.model.AccountDto;
import com.newlight77.admin.model.RoleDto;
import com.newlight77.admin.model.UserDto;
import com.newlight77.admin.neo4j.AccountEntity;
import com.newlight77.admin.neo4j.UserEntity;

import javax.management.relation.Role;
import java.util.stream.Collectors;

public class AccountMapper {

  public static AccountDto to(AccountEntity entity) {
    return AccountDto.builder()
            .name(entity.getName())
            .roles(entity.getRoles().stream().map(RoleMapper::to).collect(Collectors.toSet()))
            .id(entity.getId())
            .build();
  }

  public static AccountEntity from(AccountDto dto) {
    return AccountEntity.builder()
            .id(dto.getId())
            .name(dto.getName())
            .roles(dto.getRoles().stream().map(RoleMapper::from).collect(Collectors.toSet()))
            .build();
  }
}
