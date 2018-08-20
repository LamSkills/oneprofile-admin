package com.newlight77.admin.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class RoleDto {
  @NotEmpty
  private String name;
  private Set<RightDto> rights;
}
