package com.newlight77.admin.neo4j;

import lombok.*;
import org.neo4j.ogm.annotation.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode
@RelationshipEntity(type = "HAS_ROLE")
public class AccountRoleRelationEntity {

  @Id @GeneratedValue
  private Long id;

  @StartNode
  private UserEntity user;

  @EndNode
  private RoleEntity role;

}
