package com.newlight77.admin.repository;

import com.newlight77.admin.neo4j.UserEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserRepository extends Neo4jRepository<UserEntity, String> {

  Collection<UserEntity> findByUsername(@Param("username") String username);

}
