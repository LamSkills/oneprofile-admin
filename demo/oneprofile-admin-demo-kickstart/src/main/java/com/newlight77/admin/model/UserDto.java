package com.newlight77.admin.model;

import lombok.*;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class UserDto {
  private String firstname;
  private String lastname;
  private String username;
}
