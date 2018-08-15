package com.newlight77.admin.mapper;

import com.newlight77.admin.model.RightDto;
import com.newlight77.admin.model.RoleDto;
import com.newlight77.admin.neo4j.RoleEntity;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RoleMapper {

  public static RoleDto to(RoleEntity entity) {
    Set<RightDto> rights = new HashSet<>();
    if (!CollectionUtils.isEmpty(entity.getHasRoles())) {
      rights = entity.getHasRights().stream()
              .map(hasRight -> RightMapper.to(hasRight.getRight()))
              .collect(Collectors.toSet());
    }
    return RoleDto.builder()
            .name(entity.getName())
            .rights(rights)
            .build();
  }

  public static RoleEntity from(RoleDto dto) {
    return RoleEntity.builder()
            .name(dto.getName())
            .rights(dto.getRights().stream()
                    .map(RightMapper::from)
                    .collect(Collectors.toSet()))
            .build();
  }
}
