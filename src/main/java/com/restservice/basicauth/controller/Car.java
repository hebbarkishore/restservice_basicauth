package com.restservice.basicauth.controller;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Car {

	private @Id @GeneratedValue Long id;
	private String make;
	private String model;

	public Car() {}

	public Car(String make, String model) {
		this.make = make;
		this.model = model;
	}
}
