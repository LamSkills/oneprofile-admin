package com.newlight77.admin.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class RoleDto {
  private String name;
  private Set<RightDto> rights;
}
