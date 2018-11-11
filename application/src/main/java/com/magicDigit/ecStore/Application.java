package com.magicDigit.ecStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Date: 2018-11-03-上午11:45
 */
@SpringBootApplication
@EnableCaching
@ComponentScan({"com.magicDigit.ecStore"})
@EnableJpaAuditing
public class Application {

  private final static Logger logger = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
    logger.info("Application is Start Up Success!");
  }

}
