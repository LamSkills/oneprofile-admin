package com.newlight77.admin.repository;

import com.newlight77.admin.neo4j.RoleEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface RoleRepository extends Neo4jRepository<RoleEntity, String> {
}
