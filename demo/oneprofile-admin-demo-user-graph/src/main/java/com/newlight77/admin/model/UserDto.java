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
public class UserDto {
  private String firstname;
  private String lastname;
  private String username;
  private Set<RoleDto> roles;
}
