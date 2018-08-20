package com.newlight77.admin.repository;

import com.newlight77.admin.neo4j.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserRepository extends Neo4jRepository<UserEntity, String> {

  Page<UserEntity> findAll(Pageable pageable);

  Collection<UserEntity> findByUsername(@Param("username") String username);

  Long deleteByUsername(@Param("username") String username);

  Collection<UserEntity> findByFirstnameAndLastname(@Param("firstname") String firstname,
                                                    @Param("lastname") String lastname);

  @Query("MATCH (u:User)-[ur:HAS_ROLE]->(ro:Role)-[rr:HAS_RIGHT]->(ri:Right) RETURN u,ur,ro,rr,ri LIMIT {limit}")
  Collection<UserEntity> userGraph(@Param("limit") int limit);

}
