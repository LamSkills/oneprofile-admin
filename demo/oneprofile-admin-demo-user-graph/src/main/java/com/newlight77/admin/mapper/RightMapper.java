package com.newlight77.admin.mapper;

import com.newlight77.admin.model.RightDto;
import com.newlight77.admin.neo4j.RightEntity;

import java.time.Instant;

public class RightMapper {

  public static RightDto to(RightEntity entity) {
    return RightDto.builder()
            .primary(entity.getPrimary())
            .secondary(entity.getSecondary())
            .rights(entity.getRights())
            .build();
  }

  public static RightEntity from(RightDto dto) {
    return RightEntity.builder()
            .primary(dto.getPrimary())
            .secondary(dto.getSecondary())
            .rights(dto.getRights())
        .build();
  }
}
