package com.example.ratelimitserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * use InfinispanJCacheBucket4jConfiguration for configuration
 */
@SpringBootApplication
@EnableCaching
public class RateLimitServerWebInfinispanApplication {

    public static void main(String[] args) {
        SpringApplication.run(RateLimitServerWebInfinispanApplication.class, args);
    }

}



