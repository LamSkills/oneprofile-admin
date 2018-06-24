package com.newlight77.admin.data.entity;

import lombok.*;
import org.neo4j.ogm.annotation.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
@EqualsAndHashCode
@RelationshipEntity(type = "ACCOUNT_ROLE")
public class AccountRoleRelationEntity {

  @Id @GeneratedValue
  private Long id;

  @StartNode
  private AccountEntity account;

  @EndNode
  private RoleEntity role;

}
