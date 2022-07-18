package com.project.Freezer.Prabhjot.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FoodNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public FoodNotFoundException(String message) {
		super(message);
	}
}
