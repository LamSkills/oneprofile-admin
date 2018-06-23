package com.newlight77.admin.model;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class User {
  private String firstname;
  private String lastname;
  private String username;
}
