package com.newlight77.admin.data.runner;

import com.newlight77.admin.data.repository.InvalidUserEntityRepository;
import com.newlight77.bhavio.core.entity.user.neo4j.AccountEntity;
import com.newlight77.bhavio.core.entity.user.neo4j.RoleEntity;
import com.newlight77.bhavio.core.entity.user.neo4j.UserEntity;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spark_project.guava.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class InvalidUserEntityInjectionRunner implements CommandLineRunner {

  private static final Logger LOGGER = LoggerFactory.getLogger(InvalidUserEntityInjectionRunner.class);

  @Autowired
  private InvalidUserEntityRepository userRepository;

  @Autowired
  private JavaSparkContext javaSparkContext;

  @Autowired
  private SparkSession sparkSession;

  @Override
  public void run(final String... args) throws Exception {
    RoleEntity role = RoleEntity.builder()
        .name("admin")
        .rights(Sets.newHashSet("read"))
        .build();
    AccountEntity account = AccountEntity.builder()
        .name("default")
        .roles(Sets.newHashSet(role))
        .build();
    UserEntity entity = UserEntity.builder()
        .lastname("Jean")
        .firstname("PLAMONDON")
        .username("jeanplamondon@gmail.com")
        .accounts(Sets.newHashSet(account))
        .build();
    userRepository.save(entity);
  }
}
