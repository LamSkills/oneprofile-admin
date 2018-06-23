package com.newlight77.admin.repository;

import com.newlight77.bhavio.core.entity.user.neo4j.AccountEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AccountRepository extends Neo4jRepository<AccountEntity, Long> {
}
