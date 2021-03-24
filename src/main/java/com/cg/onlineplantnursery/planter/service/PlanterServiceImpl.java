package com.cg.onlineplantnursery.planter.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.exceptions.InvalidPlanterDataException;
import com.cg.onlineplantnursery.planter.repository.IPlanterRepository;

@Service
public class PlanterServiceImpl implements IPlanterService {

	@Autowired
	IPlanterRepository repository;

	@Transactional
	@Override
	public Planter addPlanter(Planter planter) {
		 planter = repository.save(planter);
		return planter;
	}

	@Override
	public Planter updatePlanter(Planter planter) {

		return null;
	}

	@Override
	public Planter deletePlanter(Planter planter) {

		return null;
	}

	@Override
	public Planter viewPlanter(int planterId) {
		Optional<Planter>optional=repository.findById(planterId);
		if(!optional.isPresent()) {
			throw new InvalidPlanterDataException("Planter is not found for this Id");
		}
		

		return optional.get();
	}

	@Override
	public Planter viewPlanter(String planterShape) {

		return null;
	}

	@Override
	public List<Planter> viewAllPlanters() {

		return null;
	}

	@Override
	public List<Planter> viewAllPlanters(double minCost, double maxCost) {

		return null;
	}

	public void validatePlanterHeight(float planterHeight) {
		if (planterHeight < 0.00f) {
			throw new InvalidPlanterDataException("Planter height is invalid");
		}

	}

	public void validatePlanterCapacity(int planterCapacity) {
		if (planterCapacity < 0.00) {
			throw new InvalidPlanterDataException("Planter capacity is invalid");
		}

	}

	public void validatePlanterdrainageHoles(int drainageHoles) {
		if (drainageHoles < 0) {
			throw new InvalidPlanterDataException("Planter drainageHole is invalid");
		}

	}

	public void validatePlanterCapacity(String planterShape) {
		if (planterShape == null || planterShape.isEmpty() || planterShape.trim().isEmpty()) {
			throw new InvalidPlanterDataException("Plater Shape is invalid");
		}

	}

	public void validatePlanterStock(int planterStock) {
		if (planterStock < 0) {
			throw new InvalidPlanterDataException("Planter Stock is invalid");
		}

	}

	public void validatePlanterCost(int planterCost) {
		if (planterCost < 0) {
			throw new InvalidPlanterDataException("Planter Cost is invalid");
		}

	}

}
