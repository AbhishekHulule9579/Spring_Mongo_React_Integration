package com.practice.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GLobalExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public String handleNotFound(StudentNotFoundException e) {
		return e.getMessage();
	}
}
