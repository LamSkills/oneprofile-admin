package com.newlight77.admin.model;

import lombok.*;

import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class AccountDto {
  private String id;
  private String name;
  private UserDto user;
  private Set<RoleDto> roles;
}
