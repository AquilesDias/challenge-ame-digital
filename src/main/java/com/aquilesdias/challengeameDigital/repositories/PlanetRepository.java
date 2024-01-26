package com.aquilesdias.challengeameDigital.repositories;

import com.aquilesdias.challengeameDigital.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanetRepository extends JpaRepository<Planet, Long> {

    Optional<Planet> findByName(String name);
}
