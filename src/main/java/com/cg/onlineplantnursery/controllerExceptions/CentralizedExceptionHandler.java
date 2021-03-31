package com.cg.onlineplantnursery.controllerExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.onlineplantnursery.exceptions.*;

@RestControllerAdvice
public class CentralizedExceptionHandler {
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CustomerNotFoundException.class)
	public String handleCustomerNotFound(CustomerNotFoundException e) {
		return e.getMessage();
	}
	

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CustomerNotAddedException.class)
	public String handleCustomerNotAdded(CustomerNotAddedException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidCustomerNameException.class)
	public String handleInvalidCustomerNameException(InvalidCustomerNameException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidCustomerEmailException.class)
	public String handleInvalidCustomerEmailException(InvalidCustomerEmailException e) {
		return e.getMessage();
	}
	

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidCustomerPasswordException.class)
	public String handleInvalidCustomerPasswordException(InvalidCustomerPasswordException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidCustomerIdException.class)
	public String handleInvalidCustomerIdException(InvalidCustomerIdException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(PlantNotFoundException.class)
	public String handlePlantNotFound(PlantNotFoundException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(AddPlantException.class)
	public String handleAddPlant(AddPlantException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlantCostException.class)
	public String handleInvalidPlantCost(InvalidPlantCostException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlantHeightException.class)
	public String handlePlantHeight(InvalidPlantHeightException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlantIdException.class)
	public String handlePlantId(InvalidPlantIdException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlantNameException.class)
	public String handlePlantName(InvalidPlantNameException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlantSpreadException.class)
	public String handlePlantSpread(InvalidPlantSpreadException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlantTypeException.class)
	public String handlePlantType(InvalidPlantTypeException e) {
		return e.getMessage();
	}
	
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
	@ExceptionHandler(InvalidSeedsCostException.class)
	public String handleInvalidSeedsCost(InvalidSeedsCostException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidSeedsStockException.class)
	public String handleInvalidSeedsStock(InvalidSeedsStockException e) {
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
	public String handleCatchAllException(Exception e) {
		return e.getMessage();
	}
	
	
}
