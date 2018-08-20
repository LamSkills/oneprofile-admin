package com.newlight77.admin.neo4j;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.id.UuidStrategy;

import javax.validation.constraints.NotEmpty;
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
	@NotEmpty
	@Index
	private String firstname;
	@NotEmpty
	@Index
	private String lastname;
	@NotEmpty
	@Index(unique = true)
	private String username;

	@Relationship(type = "HAS_ROLE")
	private Set<RoleEntity> roles = new HashSet<>();

	@JsonIgnoreProperties("user")
	@Relationship(type = "HAS_ROLE")
	private Set<HasRoleRelation> hasRoles = new HashSet<>();

}