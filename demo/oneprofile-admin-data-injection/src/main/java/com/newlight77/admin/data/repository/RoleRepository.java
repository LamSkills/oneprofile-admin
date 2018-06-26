package com.newlight77.admin.data.repository;

import com.newlight77.admin.data.entity.RoleEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface RoleRepository extends Neo4jRepository<RoleEntity, Long> {
}
