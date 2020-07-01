package com.restservice.basicauth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CarNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(CarNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String employeeNotFoundHandler(CarNotFoundException ex) {
		return ex.getMessage();
	}
}