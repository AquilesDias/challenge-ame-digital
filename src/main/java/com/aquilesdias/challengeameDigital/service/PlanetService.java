package com.aquilesdias.challengeameDigital.service;

import com.aquilesdias.challengeameDigital.domain.Planet;
import com.aquilesdias.challengeameDigital.domain.dto.PlanetDTO;
import com.aquilesdias.challengeameDigital.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository repository;

    public Planet save(PlanetDTO dto){
        Planet newPlanet = new Planet(dto);
        return repository.save(newPlanet);
    }

    public Planet findPlanetById(Long id){
        Planet planet = repository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Planet not found."));
        return planet;
    }

    public Planet findPlanetByName(String name){
        Planet planet = repository.findByName(name).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Planet not found."));

        return planet;
    }

    public List<Planet> findPlanetList(){
        return repository.findAll();
    }

    public void deletePlanet(Long id){
        Planet planet = findPlanetById(id);
        repository.delete(planet);
    }

}
