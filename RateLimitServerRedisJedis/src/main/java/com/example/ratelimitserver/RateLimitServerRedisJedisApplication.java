package com.example.ratelimitserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

@SpringBootApplication
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class RateLimitServerRedisJedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RateLimitServerRedisJedisApplication.class, args);
    }

}
