package com.newlight77.admin.mapper;

import com.newlight77.admin.model.RightDto;
import com.newlight77.admin.model.UserDto;
import com.newlight77.admin.neo4j.RightEntity;
import com.newlight77.admin.neo4j.UserEntity;
import com.newlight77.right.model.Right;

public class RightMapper {

  public static RightDto to(RightEntity entity) {
    return RightDto.builder()
            .primary(entity.getPrimary())
            .secondary(entity.getSecondary())
            .rights(entity.getRights())
            .tempRights(entity.getTempRights())
            .modificationDate(entity.getModificationDate())
            .build();
  }

  public static RightEntity from(RightDto dto) {
    return RightEntity.builder()
            .primary(dto.getPrimary())
            .secondary(dto.getSecondary())
            .rights(dto.getRights())
            .tempRights(dto.getTempRights())
            .modificationDate(dto.getModificationDate())
        .build();
  }
}
