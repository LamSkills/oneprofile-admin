package com.newlight77.admin.repository;

import com.newlight77.admin.neo4j.RightEntity;
import com.newlight77.right.entity.neo4j.RightNeo4jEntity;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RightRepository extends Neo4jRepository<RightEntity, String> {

  @Query("MATCH (u:Right) WHERE u.primary = {primary} AND u.secondary = {secondary} DELETE u")
  Collection<RightEntity> deleteByPrimaryAndSecondary(@Param("primary") String primary, @Param("secondary") String secondary);

  @Query("MATCH (u:Right) WHERE u.primary = {primary} AND u.secondary = {secondary} RETURN u LIMIT {limit}")
  Collection<RightEntity> findByPrimaryAndSecondary(@Param("primary") String primary, @Param("secondary") String secondary, @Param("limit") int limit);

  @Query("MATCH (r:Role)-[ua:ROLE_RIGHT]-(a:Right) RETURN r,a LIMIT {limit}")
  Collection<RightEntity> rightsByRole(@Param("limit") int limit);

}
