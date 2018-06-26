package com.newlight77.admin.data.repository;

import com.newlight77.admin.data.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserRepository extends Neo4jRepository<UserEntity, Long> {
//    Page<UserEntity> findAll(Pageable pageable);
//
//    Collection<UserEntity> findByUsername(@Param("username") String username);
//
//    Collection<UserEntity> findByFirstnameAndLastname(@Param("firstname") String firstname,
//                                                      @Param("lastname") String lastname);
//
//    @Query("MATCH (u:User)-[ua:USER_ACCOUNT]-(a:Account)-[ar:HAS_ROLE]-(r:Role) RETURN u,a,r LIMIT {limit}")
//    Collection<UserEntity> userRoles(@Param("limit") int limit);
//
//    @Query("MATCH (u:User)-[ua:USER_ACCOUNT]-(a:Accouint) RETURN l,a LIMIT {limit}")
//    Collection<UserEntity> userAccounts(@Param("limit") int limit);
}
