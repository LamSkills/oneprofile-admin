package com.newlight77.admin.mapper;

import com.newlight77.admin.model.RoleDto;
import com.newlight77.admin.neo4j.RoleEntity;

import java.util.stream.Collectors;

public class RoleMapper {

  public static RoleDto to(RoleEntity entity) {
    return RoleDto.builder()
            .name(entity.getName())
//            .rights(entity.getRights().stream().map(RightMapper::to).collect(Collectors.toSet()))
            .build();
  }

  public static RoleEntity from(RoleDto dto) {
    return RoleEntity.builder()
            .name(dto.getName())
//            .rights(dto.getRights().stream().map(RightMapper::from).collect(Collectors.toSet()))
            .build();
  }
}
