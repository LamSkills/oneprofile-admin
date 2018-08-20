package com.newlight77.admin.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class UserDto {
  @NotEmpty
  private String firstname;
  @NotEmpty
  private String lastname;
  @NotEmpty
  private String username;
  private Set<RoleDto> roles;
}
