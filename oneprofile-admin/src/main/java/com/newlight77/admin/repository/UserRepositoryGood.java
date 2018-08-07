package com.newlight77.admin.repository;

import java.util.Collection;

import com.newlight77.admin.neo4j.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepositoryGood extends Neo4jRepository<User, String> {

    @Query("MATCH (u:Account)<-[ha:HAS_ACCOUNT]-(a:User) RETURN u,ha,a LIMIT {limit}")
	Collection<User> graph(@Param("limit") int limit);
}