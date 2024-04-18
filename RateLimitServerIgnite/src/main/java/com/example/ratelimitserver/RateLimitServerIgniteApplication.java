package com.example.ratelimitserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/sun.nio.ch=ALL-UNNAMED --add-opens java.base/java.util=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED
 *  Use IgniteBucket4jCacheConfiguration for configuration
 */

@SpringBootApplication
@EnableCaching
public class RateLimitServerIgniteApplication {

    public static void main(String[] args) {
        SpringApplication.run(RateLimitServerIgniteApplication.class, args);
    }

}



