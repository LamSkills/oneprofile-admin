package com.newlight77.admin.data.repository;

import com.newlight77.admin.data.entity.UserEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRepository extends Neo4jRepository<UserEntity, Long> {

}
