package com.newlight77.admin.neo4j;

import lombok.*;
import org.neo4j.ogm.annotation.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
@EqualsAndHashCode
@RelationshipEntity(type = "HAS_ROLE")
public class RoleRightRelationEntity {

  @Id @GeneratedValue
  private Long id;

  @StartNode
  private RoleEntity role;

  @EndNode
  private RightEntity rightEntity;

}
