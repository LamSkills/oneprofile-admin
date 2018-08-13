package com.newlight77.admin.neo4j;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.id.UuidStrategy;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Getter
//@ToString
//@EqualsAndHashCode
@NodeEntity(label = "Role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    private String uid;
    private String name;

    @JsonIgnoreProperties("right")
    @Relationship(type = "HAS_ROLE", direction = Relationship.INCOMING)
    private Set<HasRoleRelation> hasRoles = new HashSet<>();


//    @JsonIgnoreProperties("right")
//    @Relationship(type = "HAS_ROLE", direction = Relationship.INCOMING)
//    private UserEntity user;

    // for Json import
    @Relationship(type = "HAS_RIGHT")
    private Set<RightEntity> rights = new HashSet<>();

    @JsonIgnoreProperties("right")
    @Relationship(type = "HAS_RIGHT")
    private Set<HasRightRelation> hasRights = new HashSet<>();

}
