package com.newlight77.admin.mapper;

import com.newlight77.admin.model.RoleDto;
import com.newlight77.admin.model.UserDto;
import com.newlight77.admin.neo4j.RoleEntity;
import com.newlight77.admin.neo4j.UserEntity;
import org.assertj.core.util.Sets;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {

  public static UserDto to(UserEntity entity) {
    Set<RoleDto> roles = Sets.newHashSet();
//    if (!CollectionUtils.isEmpty(entity.getRoles())) {
//      roles = entity.getRoles().stream()
//              .map(RoleMapper::to).collect(Collectors.toSet());
//    }
    return UserDto.builder()
            .firstname(entity.getFirstname())
            .lastname(entity.getLastname())
            .username(entity.getUsername())
            .roles(roles)
            .build();
  }

  public static UserEntity from(UserDto dto) {
    Set<RoleEntity> entities = Sets.newHashSet();
    if (!CollectionUtils.isEmpty(dto.getRoles())) {
      entities = dto.getRoles().stream().map(RoleMapper::from).collect(Collectors.toSet());
    }
    return UserEntity.builder()
            .firstname(dto.getFirstname())
            .lastname(dto.getLastname())
            .username(dto.getUsername())
//            .roles(entities)
            .build();
  }
}
