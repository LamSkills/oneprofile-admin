package com.newlight77.admin;

import org.apache.commons.io.IOUtils;
import org.neo4j.driver.v1.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import java.io.IOException;

public class Neo4jCypherRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Neo4jCypherRunner.class);

    private Driver driver;

    public Neo4jCypherRunner(String uri, String user, String password)
    {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    @Override
    public void run(final String... args) throws Exception {

        try {
            String schema = IOUtils.toString(this.getClass().getResourceAsStream("/schema.cypher"));
            String[] cyphers = schema.split(";");
            try (Session session = driver.session()) {
                for (String cypher : cyphers) {
                    try (Transaction tx = session.beginTransaction()) {
                        tx.run(cypher);
                        tx.success();
                        LOGGER.info("successfully executed cypher : {}", cypher);
                    }
                }
            }
        } catch (IOException io) {
            driver.close();
        }
    }
}
