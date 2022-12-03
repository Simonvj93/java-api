package com.example.javaapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(WatchRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Watch("Rolex", 100)));
      log.info("Preloading " + repository.save(new Watch("Michael Kors", 80)));
      log.info("Preloading " + repository.save(new Watch("Swatch", 50)));
      log.info("Preloading " + repository.save(new Watch("Casio", 30)));
    };
  }
}