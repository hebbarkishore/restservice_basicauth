package com.restservice.basicauth.exception;

public class CarNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CarNotFoundException(Long id) {
		super("Could not find car " + id);
	}
}
