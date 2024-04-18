package com.example.ratelimitserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Use JCacheBucket4jConfiguration for configuration
 */
@SpringBootApplication
@EnableCaching
public class RateLimitServerHazelcastApplication {

    public static void main(String[] args) {
        SpringApplication.run(RateLimitServerHazelcastApplication.class, args);
    }

}




