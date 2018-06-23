package com.newlight77.admin.repository;

import com.newlight77.admin.neo4j.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserRepository extends Neo4jRepository<UserEntity, Long> {

  Page<UserEntity> findAll(Pageable pageable);

  Collection<UserEntity> findByUsername(@Param("username") String username);

  Collection<UserEntity> findByFirstnameAndLastname(@Param("firstname") String firstname,
                                                    @Param("lastname") String lastname);

  @Query("MATCH (u:USER)-[ua:USER_ACCOUNT]-(a:ACCOUNT)-[ar:HAS_ROLE]-(r:ROLE) RETURN u,a,r LIMIT {limit}")
  Collection<UserEntity> userRoles(@Param("limit") int limit);

  @Query("MATCH (u:USER)-[ua:USER_ACCOUNT]-(a:ACCOUNT) RETURN l,a LIMIT {limit}")
  Collection<UserEntity> userAccounts(@Param("limit") int limit);

}
