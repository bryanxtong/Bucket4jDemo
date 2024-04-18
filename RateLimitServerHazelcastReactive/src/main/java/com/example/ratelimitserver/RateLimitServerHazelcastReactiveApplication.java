package com.example.ratelimitserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Use HazelcastReactiveBucket4jCacheConfiguration for configuration
 */
@SpringBootApplication
@EnableCaching
public class RateLimitServerHazelcastReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(RateLimitServerHazelcastReactiveApplication.class, args);
    }

}
