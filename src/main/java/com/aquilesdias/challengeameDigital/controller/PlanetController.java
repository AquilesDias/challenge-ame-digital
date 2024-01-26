package com.aquilesdias.challengeameDigital.controller;

import com.aquilesdias.challengeameDigital.domain.Planet;
import com.aquilesdias.challengeameDigital.domain.StarWarsApiResponse;
import com.aquilesdias.challengeameDigital.domain.StarWarsPlanet;
import com.aquilesdias.challengeameDigital.domain.dto.PlanetDTO;
import com.aquilesdias.challengeameDigital.external.SwApiExternalService;
import com.aquilesdias.challengeameDigital.service.PlanetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/planet")
public class PlanetController {

    private final PlanetService service;
    private final SwApiExternalService swapi;

    @PostMapping
    public ResponseEntity<Planet> save(@RequestBody PlanetDTO dto) {
        int filmAppearances = getFilmAppearances(dto.name());

        PlanetDTO planetDTO = new PlanetDTO(dto.name(), dto.climate(), dto.terrain(), filmAppearances);

        return ResponseEntity.ok().body(service.save(planetDTO));
    }

    private int getFilmAppearances(String planetName){
        StarWarsApiResponse countFilmAppearances = swapi.searchPlanet(planetName);
        List<StarWarsPlanet> results = countFilmAppearances.getResults();
        return results != null && !results.isEmpty() ? results.get(0).getFilms().size() : 0;

    }

    @GetMapping("{id}")
    public ResponseEntity<Planet> findPlanetById(@PathVariable Long id){
        return ResponseEntity.ok(service.findPlanetById(id));
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Planet> findPlanetByName(@PathVariable String name){
        return ResponseEntity.ok(service.findPlanetByName(name));
    }

    @GetMapping
    public ResponseEntity<List<Planet>> listAllPlanets(){
        return ResponseEntity.ok( service.findPlanetList() );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Planet> deletePlanet(@PathVariable Long id){
        service.deletePlanet(id);
        return ResponseEntity.ok().build();
    }

}
