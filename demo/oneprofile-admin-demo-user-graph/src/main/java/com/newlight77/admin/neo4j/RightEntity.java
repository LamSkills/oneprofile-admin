package com.newlight77.admin.neo4j;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.id.UuidStrategy;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@NodeEntity(label = "Right")
@CompositeIndex(unique = true, properties = {"primary", "secondary"})
public class RightEntity {

  @Id
  @GeneratedValue(strategy = UuidStrategy.class)
  private String uid;
  @Index
  private String primary;
  @Index
  private String secondary;
  private Set<String> rights;

  @JsonIgnoreProperties("right")
  @Relationship(type = "HAS_RIGHT", direction = Relationship.INCOMING)
  private Set<HasRightRelation> hasRights = new HashSet<>();

  @JsonIgnoreProperties("right")
  @Relationship(type = "HAS_RIGHT", direction = Relationship.INCOMING)
  private RoleEntity role;

}
