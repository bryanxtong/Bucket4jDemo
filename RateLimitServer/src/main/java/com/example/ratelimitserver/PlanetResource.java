package com.example.ratelimitserver;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.BandwidthBuilder;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
class PlanetResource {
    private Bucket bucket;
    private final List<String> PLANETS = Arrays.asList("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto");

    @GetMapping(value = "/planet", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPlanet() {
        ConsumptionProbe consumptionProbe = bucket.tryConsumeAndReturnRemaining(1);
        if (consumptionProbe.isConsumed()) {
            Collections.shuffle(PLANETS);
            return ResponseEntity.ok().header("X-Rate-Limit-Remaining", Long.toString(consumptionProbe.getRemainingTokens())).body(PLANETS.get(0));
        } else {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .header("X-Rate-Limit-Retry-After-Seconds", Long.toString(consumptionProbe.getNanosToWaitForRefill() / 1_000_000_000))
                    .body("{\"message\":\"Too Many Requests!\"}");
        }
    }

    @PostConstruct
    public void setupBucket() {
        Bandwidth bandwidth = BandwidthBuilder.builder().capacity(5).refillGreedy(5, Duration.ofMinutes(1)).build();
        this.bucket = Bucket.builder().addLimit(bandwidth).build();
    }


}
