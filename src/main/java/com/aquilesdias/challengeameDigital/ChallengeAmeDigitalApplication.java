package com.aquilesdias.challengeameDigital;

import feign.codec.ErrorDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class ChallengeAmeDigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeAmeDigitalApplication.class, args);
	}

	@Bean
	public ErrorDecoder errorDecoder() {
		return null;
	}
}
