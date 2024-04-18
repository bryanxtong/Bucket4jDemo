package com.example.ratelimitserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class RateLimitServerRedisLettuceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RateLimitServerRedisLettuceApplication.class, args);
    }
}
