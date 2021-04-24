package com.cg.onlineplantnursery.planter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.exceptions.AddPlanterException;
import com.cg.onlineplantnursery.exceptions.InvalidPlanterCapacityException;
import com.cg.onlineplantnursery.exceptions.InvalidPlanterColorException;
import com.cg.onlineplantnursery.exceptions.InvalidPlanterCostException;
import com.cg.onlineplantnursery.exceptions.InvalidPlanterDrainageHolesException;
import com.cg.onlineplantnursery.exceptions.InvalidPlanterException;
import com.cg.onlineplantnursery.exceptions.InvalidPlanterHeightException;
import com.cg.onlineplantnursery.exceptions.InvalidPlanterIdException;
import com.cg.onlineplantnursery.exceptions.InvalidPlanterShapeException;
import com.cg.onlineplantnursery.exceptions.InvalidPlanterStockException;
import com.cg.onlineplantnursery.exceptions.PlanterNotFoundException;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.repository.IPlanterRepository;

@Service
public class PlanterServiceImpl implements IPlanterService {

	@Autowired
	private IPlanterRepository planterRepository;

	/**
	 *
	 *  saves Planter in the database after validation
	 *
	 * @param planter is Planter
	 * @return saved Planter
	 */
	
	
	@Override
	public Planter addPlanter(Planter planter) {
		validatePlanter(planter);
		Planter saved = planterRepository.save(planter);
		return saved;
	}

	/**
	 *
	 *  Updating Planter in the database after validation by Id
	 *
	 * @param planter is Planter
	 * @return updated Planter
	 */
	
	@Override
	public Planter updatePlanter(Planter planter) {
		validatePlanterById(planter);
		return planterRepository.save(planter);
	}

	/**
	 *
	 *  Deleting Planter in the database after validation by Id
	 *
	 * @param planter is Planter
	 * @return Planter
	 */
	
	@Override
	public Planter deletePlanter(Planter planter) {
		validatePlanterById(planter);
		planterRepository.delete(planter);
		return planter;

	}

	/**
	 *
	 *  Finding Planter in the database after validation by Id
	 *
	 * @param planter Id
	 * @return Planter
	 */
	
	@Override
	public Planter viewPlanter(int planterId) {

		validatePlanterId(planterId);
		Optional<Planter> optional = planterRepository.findById(planterId);
		if (!optional.isPresent()) {
			throw new PlanterNotFoundException("Planter is not found for this Id");
		}

		return optional.get();
	}

	/**
	 *
	 *  Finding Planter in the database after validation by Planter Shape
	 *
	 * @param planter Shape
	 * @return Planter List
	 */
	
	
	
	@Override
	public List<Planter> viewPlanter(String planterShape) {
		validatePlanterShape(planterShape);

		List<Planter> planterList = planterRepository.findByPlanterShape(planterShape);
		if (planterList.isEmpty()) {
			throw new PlanterNotFoundException("No planters found for this shape");
		}

		return planterList;

	}
	
	
	/**
	 *
	 *  Finding  All the Planter in the database
	 *
	 * @return Planter List
	 */

	@Override
	public List<Planter> viewAllPlanters() {
		List<Planter> planterList = planterRepository.findAll();
		if (planterList.isEmpty()) {
			throw new PlanterNotFoundException("No planters found");
		}
		return planterList;
	}
	/**
	 *
	 *  Finding  All the Planter in the database by providing Cost range
	 *@param minCost and maxCost
	 * @return Planter List
	 */
	
	@Override
	public List<Planter> viewAllPlanters(double minCost, double maxCost) {
		int minCostInt = (int) minCost;
		int maxCostInt = (int) maxCost;

		List<Planter> planterList = planterRepository.findAllPlantersBetweenCost(minCostInt, maxCostInt);
		if (planterList.isEmpty()) {
			throw new PlanterNotFoundException("No planters found in this range");
		}

		return planterList;
	}

//validating the object of the planter
	public void validatePlanter(Planter planter) {

		if (planter == null) {
			throw new AddPlanterException("Planter cannot be null");
		}

		if (planter.getPlanterHeight() <= 0) {
			throw new InvalidPlanterHeightException("Planter Height cannot be null");
		}

		if (planter.getPlanterCapacity() <= 0) {
			throw new InvalidPlanterCapacityException("Planter Capacity cannot be null");
		}

		if (planter.getDrainageHoles() <= 0) {
			throw new InvalidPlanterDrainageHolesException("Planter Drainage cannot be null");
		}

		if (planter.getPlanterColor() <= 0) {
			throw new InvalidPlanterColorException("Planter color cannot be null");

		}

		if (planter.getPlanterShape().equals("")) {
			throw new InvalidPlanterShapeException("Planter shape cannot be null");

		}

		if (planter.getPlanterStock() <= 0) {
			throw new InvalidPlanterStockException("Planter Stock is invalid");
		}

		if (planter.getPlanterCost() <= 0) {
			throw new InvalidPlanterCostException("Planter Cost cannot be null");
		}

	}

//validating planter id
	public void validatePlanterId(int id) {

		if (id <= 0) {
			throw new InvalidPlanterIdException("Plant does nt exists for this id");
		}

	}

//validating shape
	public void validatePlanterShape(String planterShape) {
		if (planterShape == null || planterShape.isEmpty() || planterShape.trim().isEmpty()) {
			throw new InvalidPlanterShapeException("Planter Shape cannot be empty");

		}
	}
//Validating the planter by Id
	public void validatePlanterById(Planter planter) {
		int id = planter.getPlanterId();
		boolean exists = planterRepository.existsById(id);
		if (!exists) {
			throw new InvalidPlanterException("Planter does not exists");
		}
	}

}
