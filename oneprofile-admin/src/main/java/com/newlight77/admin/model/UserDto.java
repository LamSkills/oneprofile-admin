package com.newlight77.admin.model;

import lombok.*;

import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class UserDto {
  private String firstname;
  private String lastname;
  private String username;
  private Set<AccountDto> accounts;
}
