package com.newlight77.admin.data.repository;

import com.newlight77.bhavio.core.entity.user.neo4j.UserEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface InvalidUserEntityRepository extends Neo4jRepository<UserEntity, Long> {

}
