package com.aquilesdias.challengeameDigital.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class StarWarsApiResponse {

    @JsonProperty("results")
    private List<StarWarsPlanet> results;

}
