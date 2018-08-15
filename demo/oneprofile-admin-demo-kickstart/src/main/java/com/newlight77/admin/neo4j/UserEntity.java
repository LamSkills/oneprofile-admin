package com.newlight77.admin.neo4j;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.id.UuidStrategy;

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
}