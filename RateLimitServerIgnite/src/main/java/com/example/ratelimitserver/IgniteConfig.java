package com.example.ratelimitserver;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IgniteConfig {
    @Bean
    public Ignite ignite(){
        return Ignition.start(this.getClass().getClassLoader().getResource("config/default-config.xml"));
    }
}
