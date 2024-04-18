package com.example.ratelimitserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Use HazelcastSpringBucket4jCacheConfiguration for configuration
 */
@SpringBootApplication
@EnableCaching
public class RateLimitServerHazelcastSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(RateLimitServerHazelcastSpringApplication.class, args);
    }

}
