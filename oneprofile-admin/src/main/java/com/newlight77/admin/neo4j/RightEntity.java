package com.newlight77.admin.neo4j;

import com.newlight77.right.model.Right;
import com.newlight77.right.model.TemporaryRight;
import lombok.*;
import org.neo4j.ogm.annotation.CompositeIndex;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString
@EqualsAndHashCode
@NodeEntity(label = "Right")
@CompositeIndex(unique = true, properties = {"primary", "secondary"})
public class RightEntity implements Serializable{

  private static final long serialVersionUID = 2196530990380331933L;

  public RightEntity() {}

  @Id
//  @GeneratedValue(strategy = UuidStrategy.class)
//  private String uid;
  private String primary;
  private String secondary;
  private Set<Right> rights;
  private Set<TemporaryRight> tempRights;
  private Instant modificationDate;

  @Relationship(type = "ROLE_RIGHT", direction = Relationship.INCOMING)
  private RoleEntity role;

}
