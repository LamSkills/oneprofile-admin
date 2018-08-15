package com.newlight77.admin.neo4j;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.id.UuidStrategy;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@NodeEntity(label = "Role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    private String uid;
    private String name;

    @JsonIgnoreProperties("right")
    @Relationship(type = "HAS_ROLE", direction = Relationship.INCOMING)
    private Set<HasRoleRelation> hasRoles = new HashSet<>();

    @Relationship(type = "HAS_RIGHT")
    private Set<RightEntity> rights = new HashSet<>();

    @JsonIgnoreProperties("right")
    @Relationship(type = "HAS_RIGHT")
    private Set<HasRightRelation> hasRights = new HashSet<>();

}
