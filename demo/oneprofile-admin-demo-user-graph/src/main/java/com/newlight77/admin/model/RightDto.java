package com.newlight77.admin.model;

import com.newlight77.admin.neo4j.RoleEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class RightDto {
  private String primary;
  private String secondary;
  private Set<String> rights;
  private RoleEntity role;
}
