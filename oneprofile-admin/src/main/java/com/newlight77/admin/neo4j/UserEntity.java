package com.newlight77.admin.neo4j;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.id.UuidStrategy;

import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
@EqualsAndHashCode
@NodeEntity(label = "User")
public class UserEntity implements Serializable {

  private static final long serialVersionUID = -2587934582432669382L;

  @Id @GeneratedValue(strategy = UuidStrategy.class)
  private String uid;
  private String firstname;
  private String lastname;
  private String username;

  @Relationship(type = "USER_ACCOUNT", direction = Relationship.OUTGOING)
  private Set<AccountEntity> accounts;

}
