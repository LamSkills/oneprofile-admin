package com.newlight77.admin.repository;

import com.newlight77.admin.neo4j.User;
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

  Collection<UserEntity> findByFirstnameAndLastname(@Param("firstname") String firstname,
                                                    @Param("lastname") String lastname);


  @Query("MATCH (u:Account)<-[ha:HAS_ACCOUNT]-(a:User) RETURN u,ha,a LIMIT {limit}")
  Collection<UserEntity> userAccounts(@Param("limit") int limit);

//  @Query("MATCH (u:User)-[ua:HAS_ACCOUNT]->(a:Account) RETURN u,ua,a LIMIT {limit}")
//  Collection<UserEntity> userAccounts(@Param("limit") int limit);

  @Query("MATCH (us:User)-[ua:HAS_ACCOUNT]->(ac:Account)-[ar:HAS_ROLE]->(ro:Role)-[rr:ROLE_RIGHT]->(ri:Right) RETURN us,ua,ac,ar,ro,rr,ri LIMIT {limit}")
  Collection<UserEntity> graph(@Param("limit") int limit);

}
