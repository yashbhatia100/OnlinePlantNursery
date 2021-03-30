package com.cg.onlineplantnursery.seed.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

import com.cg.onlineplantnursery.exceptions.*;

@RestControllerAdvice
public class CentralizedExceptionHandler {


	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(SeedNotFoundException.class)
	public String handleSeedNotFound(SeedNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidSeedIdException.class)
	public String handleInvalidSeedId(InvalidSeedIdException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidSeedNameException.class)
	public String handleInvalidSeedName(InvalidSeedNameException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidSeedTypeException.class)
	public String handleInvalidSeedType(InvalidSeedTypeException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(SeedAddException.class)
	public String handleSeedAdd(SeedAddException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String handleCatchAll(Exception e) {
		return e.getMessage();
	}

}
