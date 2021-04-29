package com.cg.onlineplantnursery.controllerExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.slf4j.*;
import com.cg.onlineplantnursery.exceptions.*;

@RestControllerAdvice
public class CentralizedExceptionHandler {
	private static final Logger Log= LoggerFactory.getLogger(CentralizedExceptionHandler.class);
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CustomerNotFoundException.class)
	public String handleCustomerNotFound(CustomerNotFoundException e) {
		Log.error("exception found inside  handleCustomerNotFound ",e);
		return e.getMessage();
	}
	

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CustomerNotAddedException.class)
	public String handleCustomerNotAdded(CustomerNotAddedException e) {
		Log.error("exception found inside  handleCustomerNotAdded ",e);
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidCustomerNameException.class)
	public String handleInvalidCustomerNameException(InvalidCustomerNameException e) {
		Log.error("exception found inside  handleInvalidCustomerNameException ",e);
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidCustomerEmailException.class)
	public String handleInvalidCustomerEmailException(InvalidCustomerEmailException e) {
		Log.error("exception found inside  handleInvalidCustomerEmailException ",e);
		return e.getMessage();
	}
	

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidCustomerPasswordException.class)
	public String handleInvalidCustomerPasswordException(InvalidCustomerPasswordException e) {
		Log.error("exception found inside  handleInvalidCustomerPasswordException ",e);
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidCustomerIdException.class)
	public String handleInvalidCustomerIdException(InvalidCustomerIdException e) {
		Log.error("exception found inside  handleInvalidCustomerIdException ",e);
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(PlantNotFoundException.class)
	public String handlePlantNotFound(PlantNotFoundException e) {
		Log.error("exception found inside  handlePlantNotFound ",e);
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(AddPlantException.class)
	public String handleAddPlant(AddPlantException e) {
		Log.error("exception found inside  handleAddPlant ",e);
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlantCostException.class)
	public String handleInvalidPlantCost(InvalidPlantCostException e) {
		Log.error("exception found inside  handleInvalidPlantCost ",e);
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlantHeightException.class)
	public String handlePlantHeight(InvalidPlantHeightException e) {
		Log.error("exception found inside  handlePlantHeight ",e);
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlantIdException.class)
	public String handlePlantId(InvalidPlantIdException e) {
		Log.error("exception found inside   handlePlantId ",e);
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlantNameException.class)
	public String handlePlantName(InvalidPlantNameException e) {
		Log.error("exception found inside   handlePlantName ",e);
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlantSpreadException.class)
	public String handlePlantSpread(InvalidPlantSpreadException e) {
		Log.error("exception found inside  handlePlantSpread ",e);
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlantTypeException.class)
	public String handlePlantType(InvalidPlantTypeException e) {
		Log.error("exception found inside  handlePlantType ",e);
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(PlanterNotFoundException.class)
	public String handlePlanterNotFound(PlanterNotFoundException e) {
		Log.error("exception found inside  handlePlanterNotFound ",e);
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlanterIdException.class)
	public String handleInvalidPlanterId(InvalidPlanterIdException e) {
		Log.error("exception found inside handleInvalidPlanterId",e);
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlanterColorException.class)
	public String handleInvalidPlanterColor(InvalidPlanterColorException e) {
		Log.error("exception found inside handleInvalidPlanterColor",e);
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlanterShapeException.class)
	public String handleInvalidPlanterShape(InvalidPlanterShapeException e) {
		Log.error("exception found inside handleInvalidPlanterShape",e);
		
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlanterCapacityException.class)
	public String handleInvalidPlanterCapacity(InvalidPlanterCapacityException e) {
		Log.error("exception found inside handleInvalidPlanterCapacity",e);
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlanterHeightException.class)
	public String handleInvalidPlanterHeight(InvalidPlanterHeightException e) {
		Log.error("exception found inside handleInvalidPlanterHeight",e);
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlanterCostException.class)
	public String handleInvalidPlanterCost(InvalidPlanterCostException e) {
		Log.error("exception found inside handleInvalidPlanterCost",e);
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlanterStockException.class)
	public String handleInvalidPlanterStock(InvalidPlanterStockException e) {
		Log.error("exception found inside handleInvalidPlanterStock",e);
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPlanterDrainageHolesException.class)
	public String handleInvalidPlanterDrainageHoles(InvalidPlanterDrainageHolesException e) {
		Log.error("exception found inside handleInvalidPlanterDrainageHoles",e);
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(SeedNotFoundException.class)
	public String handleSeedNotFound(SeedNotFoundException e) {
		Log.error("exception found inside handleSeedNotFound",e);
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidSeedIdException.class)
	public String handleInvalidSeedId(InvalidSeedIdException e) {
		Log.error("exception found inside  handleInvalidSeedId",e);
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidSeedsCostException.class)
	public String handleInvalidSeedsCost(InvalidSeedsCostException e) {
		Log.error("exception found inside handleInvalidSeedsCost",e);
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidSeedsStockException.class)
	public String handleInvalidSeedsStock(InvalidSeedsStockException e) {
		Log.error("exception found inside handleInvalidSeedsStock",e);
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidSeedNameException.class)
	public String handleInvalidSeedName(InvalidSeedNameException e) {
		Log.error("exception found inside handleInvalidSeedName",e);
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidSeedTypeException.class)
	public String handleInvalidSeedType(InvalidSeedTypeException e) {
		Log.error("exception found inside handleInvalidSeedType",e);
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(SeedAddException.class)
	public String handleSeedAdd(SeedAddException e) {
		Log.error("exception found inside handleSeedAdd",e);
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String handleCatchAllException(Exception e) {
		Log.error("exception found in handleCatchAllException ",e);
		return e.getMessage();
	}
	
	
}
