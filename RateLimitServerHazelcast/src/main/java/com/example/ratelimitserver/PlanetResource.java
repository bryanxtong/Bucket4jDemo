package com.example.ratelimitserver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
class PlanetResource {

    private final List<String> PLANETS = Arrays.asList("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto");

    @GetMapping("/planet")
    public ResponseEntity<String> getPlanet() {
        Collections.shuffle(PLANETS);
        return ResponseEntity.ok().body(PLANETS.get(0));
    }
}
