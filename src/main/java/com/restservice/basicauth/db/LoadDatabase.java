package com.restservice.basicauth.db;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.restservice.basicauth.controller.Car;

@Configuration
@Slf4j
public class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(CarRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Car("Toyota", "Camry")));
			log.info("Preloading " + repository.save(new Car("Honda", "Accord")));
		};
	}
}
