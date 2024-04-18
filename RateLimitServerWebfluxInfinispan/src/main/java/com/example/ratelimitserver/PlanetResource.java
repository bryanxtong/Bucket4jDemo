package com.example.ratelimitserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
class PlanetResource {

    private final List<String> PLANETS = Arrays.asList("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto");

    @GetMapping("/planet")
    public Mono<String> getPlanet() {
        Collections.shuffle(PLANETS);
        return Mono.just(PLANETS.get(0));
    }
}
