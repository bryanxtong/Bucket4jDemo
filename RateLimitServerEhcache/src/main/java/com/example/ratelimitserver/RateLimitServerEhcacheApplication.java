package com.example.ratelimitserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RateLimitServerEhcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(RateLimitServerEhcacheApplication.class, args);
    }

}
