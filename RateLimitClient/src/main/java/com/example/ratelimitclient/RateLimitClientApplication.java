package com.example.ratelimitclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@SpringBootApplication
public class RateLimitClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RateLimitClientApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Component
    class Runner implements CommandLineRunner {
        Logger LOG = LoggerFactory.getLogger(Runner.class);
        @Autowired
        RestTemplate restTemplate;

        @Override
        public void run(String... args) throws Exception {
            while (true) {
                Thread.sleep(10000);
                try {
                    ResponseEntity<String> entity = restTemplate.getForEntity(new URI("http://localhost:8083/planet"), String.class);
                    if (entity.getStatusCode().equals(HttpStatus.OK)) {
                        LOG.info(String.format("Planet received %s\n Headers: %s", entity.getBody(), entity.getHeaders().toString()));
                    } else {
                        LOG.warn(String.format("status code received %s", entity.getStatusCode()));
                    }
                } catch (HttpClientErrorException e) {
                    if (e.getStatusCode().isSameCodeAs(HttpStatus.TOO_MANY_REQUESTS)) {
                        LOG.warn("Rate limit exhausted");
                        LOG.info("Await time before refill: " + e.getResponseHeaders().toString());
                    }
                }
            }

        }
    }
}
