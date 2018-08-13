package com.newlight77.admin.neo4j;

import lombok.*;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.id.UuidStrategy;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Getter
//@ToString
//@EqualsAndHashCode
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
