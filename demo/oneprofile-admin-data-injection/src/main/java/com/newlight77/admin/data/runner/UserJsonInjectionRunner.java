package com.newlight77.admin.data.runner;

import com.newlight77.admin.data.csv.SparkUserMapper;
import com.newlight77.admin.data.entity.UserEntity;
import com.newlight77.admin.data.repository.UserRepository;
import org.apache.commons.lang.StringUtils;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UserJsonInjectionRunner implements CommandLineRunner {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserJsonInjectionRunner.class);

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private JavaSparkContext javaSparkContext;

  @Autowired
  private SparkSession sparkSession;

  @Value("${data.path:/data}")
  String dataPath;

  @Override
  public void run(final String... args) throws Exception {
    String path = Paths.get(dataPath, "user.json").toString();
    if (StringUtils.isBlank(dataPath) || Files.isDirectory(Paths.get(path))) {
      path = this.getClass().getResource("/data/user.json").getPath();
    }
    LOGGER.info("injecting data from file: {}", path);

    Dataset<UserEntity> ds = sparkSession.sqlContext().read()
        .option("mode", "DROPMALFORMED")
        .option("header", "true")
        .option("charset", "UTF-8")
        .json(path)
        .map(new SparkUserMapper(),
            Encoders.kryo(UserEntity.class));

    List<UserEntity> users = ds.collectAsList();

    users.forEach(user -> {
          user = userRepository.save(user);
          LOGGER.info("user={}", user.toString());
        }
    );

    LOGGER.info("total={}", users.size());
  }

}
