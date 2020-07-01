package com.restservice.basicauth.controller;


import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.restservice.basicauth.db.CarRepository;
import com.restservice.basicauth.exception.CarNotFoundException;

@RestController
public class CarController {

	private final CarRepository repository;

	CarController(CarRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/cars")
	ResponseEntity<List<Car>> getAvailableCars() {

		List<Car> cars = repository.findAll();
		return new ResponseEntity<>(cars, HttpStatus.OK);
	}

	@PostMapping("/cars")
	ResponseEntity<Car> newCar(@RequestBody Car newCar) {
		return new ResponseEntity<>(repository.save(newCar), HttpStatus.CREATED);
	}

	// Single item
	@GetMapping("/cars/{id}")
	ResponseEntity<Car> getCarById(@PathVariable Long id) {
		
		Car car = repository.findById(id)
			.orElseThrow(() -> new CarNotFoundException(id));
		
		return new ResponseEntity<>(car, HttpStatus.OK);
	}

	@PutMapping("/cars/{id}")
	Car replaceCar(@RequestBody Car newCar, @PathVariable Long id) {
		
		return repository.findById(id)
			.map(car -> {
				car.setMake(newCar.getMake());
				car.setModel(newCar.getModel());
				return repository.save(car);
			})
			.orElseGet(() -> {
				newCar.setId(id);
				return repository.save(newCar);
			});
	}

	@DeleteMapping("/cars/{id}")
	void deleteCar(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
