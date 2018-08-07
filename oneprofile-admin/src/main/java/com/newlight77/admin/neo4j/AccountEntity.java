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
@NoArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode
@NodeEntity(label = "Account")
public class AccountEntity implements Serializable{

  private static final long serialVersionUID = -2960459936173459148L;

  @Id @GeneratedValue(strategy = UuidStrategy.class)
  private String id;
  private String name;

  @Relationship(type = "HAS_ACCOUNT", direction = Relationship.INCOMING)
  private UserAccountRelationEntity userAccounts;

  @Relationship(type = "HAS_ROLE")
  private Set<RoleEntity> roles;

}
