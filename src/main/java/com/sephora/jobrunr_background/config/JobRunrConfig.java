package com.sephora.jobrunr_background.config;

import io.lettuce.core.RedisClient;
import org.jobrunr.jobs.mappers.JobMapper;
import org.jobrunr.storage.InMemoryStorageProvider;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.nosql.redis.LettuceRedisStorageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobRunrConfig {

  // Configure Memmory storage provider
  // @Bean
  // public StorageProvider storageProvider(JobMapper jobMapper) {
  //   InMemoryStorageProvider storageProvider = new InMemoryStorageProvider();
  //   storageProvider.setJobMapper(jobMapper);
  //   return storageProvider;
  // }

  // Configure Redis storage provider
  @Bean
  StorageProvider initProvider(JobMapper mapper) {
      RedisClient client = RedisClient.create("redis://localhost:6379/0");
      LettuceRedisStorageProvider provider = new LettuceRedisStorageProvider(client);
      provider.setJobMapper(mapper);
      return provider;
  }
}



