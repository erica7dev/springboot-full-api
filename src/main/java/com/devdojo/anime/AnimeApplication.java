package com.devdojo.anime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;

@SpringBootApplication
public class AnimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimeApplication.class, args);
	}

	@Bean
	MeterRegistryCustomizer<MeterRegistry> configurer( {
		@Value("${spring.application.name}") String applicationName){
			return (registry) -> registry.config().commonTags("application", applicationName);
		}
	}

}
