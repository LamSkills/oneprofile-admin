package com.newlight77.admin.data.repository;

import com.newlight77.admin.data.entity.AccountEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AccountRepository extends Neo4jRepository<AccountEntity, Long> {
}
