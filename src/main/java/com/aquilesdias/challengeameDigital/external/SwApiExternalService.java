package com.aquilesdias.challengeameDigital.external;

import com.aquilesdias.challengeameDigital.domain.StarWarsApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${SW_API_BASE_URL}", name = "swapi-service")
public interface SwApiExternalService {

    @GetMapping("api/planets/?search={planetName}")
    StarWarsApiResponse searchPlanet(@PathVariable String planetName);
}
