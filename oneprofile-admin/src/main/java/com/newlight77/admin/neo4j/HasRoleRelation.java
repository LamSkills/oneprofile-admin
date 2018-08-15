package com.newlight77.admin.neo4j;

import lombok.*;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.id.UuidStrategy;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@RelationshipEntity(type = "HAS_ROLE")
public class HasRoleRelation {

    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    private String uid;

    @StartNode
    private UserEntity user;

    @EndNode
    private RoleEntity role;

}
