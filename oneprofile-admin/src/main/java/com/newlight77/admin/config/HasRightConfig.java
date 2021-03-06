package com.newlight77.admin.config;

import com.newlight77.right.annotation.DB;
import com.newlight77.right.annotation.EnableRightAspect;
import com.newlight77.right.repository.neo4j.RightNeo4jRepository;
import com.newlight77.right.service.HasRightService;
import com.newlight77.right.service.impl.HasRightNeo4JService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRightAspect(db = DB.NEO4J)
@Configuration
public class HasRightConfig {

    @Autowired
    RightNeo4jRepository rightNeo4jRepository;

    @Bean
    public HasRightService hasRightService() {
        return new HasRightNeo4JService(rightNeo4jRepository);
    }

}
