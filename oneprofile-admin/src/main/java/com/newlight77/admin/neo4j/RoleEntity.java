package com.newlight77.admin.neo4j;

import lombok.*;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode
@NodeEntity(label = "UserAccount")
public class RoleEntity implements Serializable{

  private static final long serialVersionUID = -3797459194489226166L;

  @Id
  private String name;

  @Relationship(type = "HAS_ROLE", direction = Relationship.INCOMING)
  private Set<AccountRoleRelationEntity> userRoles;

  @Relationship(type = "ROLE_RIGHT")
  private Set<RightEntity> rights;

}
