package com.newlight77.admin.neo4j;

import com.newlight77.admin.neo4j.AccountEntity;
import com.newlight77.admin.neo4j.UserEntity;
import lombok.*;
import org.neo4j.ogm.annotation.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
@EqualsAndHashCode
@RelationshipEntity(type = "USER_ACCOUNT")
public class UserAccountRelationEntity {

  @Id @GeneratedValue
  private Long id;

  @StartNode
  private UserEntity user;

  @EndNode
  private AccountEntity account;


}
