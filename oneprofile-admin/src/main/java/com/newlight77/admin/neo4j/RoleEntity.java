package com.newlight77.admin.neo4j;

import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
@EqualsAndHashCode
@NodeEntity(label = "RoleDto")
public class RoleEntity implements Serializable{

  private static final long serialVersionUID = -3797459194489226166L;

  @Id
  private String name;
//  private Set<String> rights;

  @Relationship(type = "HAS_ROLE", direction = Relationship.INCOMING)
  private Set<UserRoleRelationEntity> userRoles;

  @Relationship(type = "ROLE_RIGHT", direction = Relationship.OUTGOING)
  private Set<RightEntity> rights;

}
