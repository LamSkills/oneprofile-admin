package com.newlight77.admin.data.entity;

import lombok.*;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.id.UuidStrategy;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
@EqualsAndHashCode
@NodeEntity(label = "User")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = UuidStrategy.class)
  private UUID id;
  private String firstname;
  private String lastname;
  private String username;

  @Relationship(type = "USER_ACCOUNT", direction = Relationship.OUTGOING)
  private Set<AccountEntity> accounts;

}
