package com.cg.onlineplantnursery.planter.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.exceptions.InvalidPlanterDataException;
import com.cg.onlineplantnursery.planter.exceptions.InvalidPlanterException;
import com.cg.onlineplantnursery.planter.exceptions.InvalidPlanterIdException;
import com.cg.onlineplantnursery.planter.exceptions.PlanterDeleteException;
import com.cg.onlineplantnursery.planter.exceptions.PlanterUpdateException;
import com.cg.onlineplantnursery.planter.repository.IPlanterRepository;

@Service
public class PlanterServiceImpl implements IPlanterService {

	@Autowired
	IPlanterRepository planterRepository;

	@Transactional
	@Override
	public Planter addPlanter(Planter planter) {
		validatePlanter(planter);
		validatePlanterHeight(planter.getPlanterHeight());
		validateDrainageHoles(planter.getDrainageHoles());
		validatePlanterCapacity(planter.getPlanterCapacity());
		validatePlanterColor(planter.getPlanterColor());
		validatePlanterCost(planter.getPlanterCost());
		validatePlanterStock(planter.getPlanterStock());
		validatePlanterShape(planter.getPlanterShape());

		Planter saved = planterRepository.save(planter);
		return saved;
	}

	@Override
	public Planter updatePlanter(Planter planter) {
		Integer id = planter.getPlanterId();
		boolean exists = planterRepository.existsById(id);
		if (!exists) {
			throw new PlanterUpdateException("Planter does not exists");

		}

		planter.setPlanterShape("Cylinderical");

		return planterRepository.save(planter);
	}

	@Override
	public Planter deletePlanter(Planter planter) {
		int id = planter.getPlanterId();

		boolean exists = planterRepository.existsById(id);
		if (!exists) {
			throw new PlanterDeleteException("Planter does not exists");

		}
		planterRepository.delete(planter);
		return planter;

	}

	@Override
	public Planter viewPlanter(int planterId) {
		Optional<Planter> optional = planterRepository.findById(planterId);
		if (!optional.isPresent()) {
			throw new InvalidPlanterIdException("Planter is not found for this Id");
		}

		return optional.get();
	}

	@Override
	public List<Planter> viewPlanter(String planterShape) {

		List<Planter> planterList = planterRepository.viewPlanter(planterShape);
		if (planterList.isEmpty()) {
			return null;
		}

		return planterList;

	}

	@Override
	public List<Planter> viewAllPlanters() {
		List<Planter> planterList = planterRepository.viewAllPlanters();
		if (planterList.isEmpty()) {
			return null;
		}

		return planterList;
	}

	@Override
	public List<Planter> viewAllPlanters(double minCost, double maxCost) {

		List<Planter> planterList = planterRepository.viewAllPlanters(minCost, maxCost);
		if (planterList.isEmpty()) {
			return null;
		}

		return planterList;
	}

	public void validatePlanter(Planter planter) {
		if (planter == null) {
			throw new InvalidPlanterException("Planter cannot be null");
		}

	}

	public void validatePlanterHeight(float planterHeight) {
		if (planterHeight < 0) {
			throw new InvalidPlanterDataException("Planterheight cannot be null");
		}
	}

	public void validatePlanterStock(int planterStock) {
		if (planterStock < 0) {
			throw new InvalidPlanterDataException("Stock cannnot be zero");
		}

	}

	public void validatePlanterCost(int planterCost) {
		if (planterCost < 0) {
			throw new InvalidPlanterDataException("Cost cannnot be zero");
		}

	}

	public void validatePlanterColor(String planterColor) {
		if (planterColor == null || planterColor.isEmpty() || planterColor.trim().isEmpty()) {
			throw new InvalidPlanterDataException("Color cannnot be null");
		}

	}

	public void validatePlanterCapacity(int planterCapacity) {
		if (planterCapacity < 0) {
			throw new InvalidPlanterDataException("Capacity cannnot be null");
		}
	}

	public void validateDrainageHoles(int drainageHoles) {
		if (drainageHoles < 0) {
			throw new InvalidPlanterDataException("Drainage Holes cannnot be zero");
		}

	}

	public void validatePlanterShape(String planterShape) {
		if (planterShape == null || planterShape.isEmpty() || planterShape.trim().isEmpty()) {
			throw new InvalidPlanterDataException("Shape cannnot be zero");
		}

	}

}
