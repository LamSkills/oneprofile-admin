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
@NodeEntity(label = "User")
public class UserEntity {

	@Id @GeneratedValue(strategy = UuidStrategy.class)
	private String uid;
	private String firstname;
	private String lastname;
	private String username;

	@Relationship(type = "HAS_ROLE")
	private Set<RoleEntity> roles = new HashSet<>();

	@JsonIgnoreProperties("user")
	@Relationship(type = "HAS_ROLE")
	private Set<HasRoleRelation> hasRoles = new HashSet<>();

}