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

  Collection<UserEntity> findByFirstnameAndLastname(@Param("firstname") String firstname,
                                                    @Param("lastname") String lastname);

  @Query("MATCH (u:UserDto)-[ua:USER_ACCOUNT]-(a:AccountDto) RETURN l,a LIMIT {limit}")
  Collection<UserEntity> userAccounts(@Param("limit") int limit);

  @Query("MATCH (us:UserDto)-[ua:USER_ACCOUNT]-(ac:AccountDto)-[ar:HAS_ROLE]-(ro:RoleDto)-[rr:ROLE_RIGHT]-(ri:RightDto) RETURN us,ac,ro,ro LIMIT {limit}")
  Collection<UserEntity> userRoles(@Param("limit") int limit);

}
