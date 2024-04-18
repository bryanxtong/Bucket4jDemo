package com.example.ratelimitserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(UriConfiguration.class)
@EnableCaching
public class RateLimitServerGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(RateLimitServerGatewayApplication.class, args);
    }


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder, UriConfiguration uriConfiguration){
        String httpbin = uriConfiguration.getHttpbin();
        return routeLocatorBuilder.routes().route(p -> p.path("/ip")
                .filters(f -> f.addRequestHeader("ip", "ip"))
                .uri(httpbin)).build();
    }
}


