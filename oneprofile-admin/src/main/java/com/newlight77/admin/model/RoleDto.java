package com.newlight77.admin.model;

import lombok.*;

import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class RoleDto {
  private String name;
  private Set<RightDto> rights;
}
