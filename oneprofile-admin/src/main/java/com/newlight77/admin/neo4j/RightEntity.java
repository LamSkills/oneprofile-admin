package com.newlight77.admin.neo4j;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.newlight77.right.model.Right;
import com.newlight77.right.model.TemporaryRight;
import lombok.*;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.id.UuidStrategy;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Getter
//@ToString
//@EqualsAndHashCode
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
  private Set<Right> rights;
  private Set<TemporaryRight> tempRights;
  private Instant modificationDate;

  @JsonIgnoreProperties("right")
  @Relationship(type = "HAS_RIGHT", direction = Relationship.INCOMING)
  private Set<HasRightRelation> hasRights = new HashSet<>();

  // for Json import
  @JsonIgnoreProperties("right")
  @Relationship(type = "HAS_RIGHT", direction = Relationship.INCOMING)
  private RoleEntity role;

}
