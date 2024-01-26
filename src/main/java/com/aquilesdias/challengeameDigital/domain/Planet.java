package com.aquilesdias.challengeameDigital.domain;

import com.aquilesdias.challengeameDigital.domain.dto.PlanetDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String climate;
    private String terrain;
    private int countFilmAppearances;

    public Planet(PlanetDTO dto) {
        this.name = dto.name();
        this.climate = dto.climate();
        this.terrain = dto.terrain();
        this.countFilmAppearances = dto.countFilmAppearances();
    }
}
