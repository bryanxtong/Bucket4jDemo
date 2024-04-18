package com.example.ratelimitserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RateLimitServerRedissonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RateLimitServerRedissonApplication.class, args);
    }

}
