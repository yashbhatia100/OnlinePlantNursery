package com.cg.onlineplantnursery.planter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.onlineplantnursery.exceptions.InvalidPlanterCapacityException;
import com.cg.onlineplantnursery.exceptions.InvalidPlanterColorException;
import com.cg.onlineplantnursery.exceptions.InvalidPlanterCostException;
import com.cg.onlineplantnursery.exceptions.InvalidPlanterDrainageHolesException;
import com.cg.onlineplantnursery.exceptions.InvalidPlanterHeightException;
import com.cg.onlineplantnursery.exceptions.InvalidPlanterIdException;
import com.cg.onlineplantnursery.exceptions.InvalidPlanterShapeException;
import com.cg.onlineplantnursery.exceptions.InvalidPlanterStockException;
import com.cg.onlineplantnursery.exceptions.PlanterNotFoundException;

@RestControllerAdvice
public class CentralizedExceptionHandler {
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(PlanterNotFoundException.class)
	public String handlePlanterNotFound(PlanterNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlanterIdException.class)
	public String handleInvalidPlanterId(InvalidPlanterIdException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlanterColorException.class)
	public String handleInvalidPlanterColor(InvalidPlanterColorException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlanterShapeException.class)
	public String handleInvalidPlanterShape(InvalidPlanterShapeException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlanterCapacityException.class)
	public String handleInvalidPlanterCapacity(InvalidPlanterCapacityException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlanterHeightException.class)
	public String handleInvalidPlanterHeight(InvalidPlanterHeightException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlanterCostException.class)
	public String handleInvalidPlanterCost(InvalidPlanterCostException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlanterStockException.class)
	public String handleInvalidPlanterStock(InvalidPlanterStockException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlanterDrainageHolesException.class)
	public String handleInvalidPlanterDrainageHoles(InvalidPlanterDrainageHolesException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String handleCatchAllException(Exception e) {
		return e.getMessage();
	}

}
