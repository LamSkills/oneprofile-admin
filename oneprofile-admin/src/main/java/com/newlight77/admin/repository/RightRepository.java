package com.newlight77.admin.repository;

import com.newlight77.admin.neo4j.RightEntity;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RightRepository extends Neo4jRepository<RightEntity, String> {

  Iterable<RightEntity> findByPrimaryAndSecondary(String primary, String secondary);

  @Query("MATCH (u:RoleDto)-[ua:ROLE_RIGHT]-(a:RightDto) RETURN l,a LIMIT {limit}")
  Collection<RightEntity> rightsByRole(@Param("limit") int limit);

}
