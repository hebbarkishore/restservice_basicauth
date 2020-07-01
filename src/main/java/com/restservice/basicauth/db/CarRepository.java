package com.restservice.basicauth.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restservice.basicauth.controller.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
