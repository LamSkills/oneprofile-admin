package com.newlight77.admin.mapper;

import com.newlight77.admin.model.RoleDto;
import com.newlight77.admin.neo4j.RoleEntity;
import com.newlight77.admin.neo4j.UserEntity;
import com.newlight77.admin.model.UserDto;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {

  public static UserDto to(UserEntity entity) {
    Set<RoleDto> roles = new HashSet<>();
    if (!CollectionUtils.isEmpty(entity.getHasRoles())) {
      roles = entity.getHasRoles().stream()
              .map(hasRole -> RoleMapper.to(hasRole.getRole()))
              .collect(Collectors.toSet());
    }
    return UserDto.builder()
            .firstname(entity.getFirstname())
            .lastname(entity.getLastname())
            .username(entity.getUsername())
            .roles(roles)
            .build();
  }

  public static UserEntity from(UserDto dto) {
    Set<RoleEntity> roles = new HashSet<>();
    if (!CollectionUtils.isEmpty(dto.getRoles())) {
      roles = dto.getRoles().stream()
              .map(RoleMapper::from)
              .collect(Collectors.toSet());
    }
    return UserEntity.builder()
            .firstname(dto.getFirstname())
            .lastname(dto.getLastname())
            .username(dto.getUsername())
            .roles(roles)
            .build();
  }
}
