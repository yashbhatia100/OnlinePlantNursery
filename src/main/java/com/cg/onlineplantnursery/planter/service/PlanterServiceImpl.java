package com.cg.onlineplantnursery.planter.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.exceptions.InvalidPlanterException;
import com.cg.onlineplantnursery.planter.exceptions.InvalidPlanterIdException;
import com.cg.onlineplantnursery.planter.exceptions.PlanterDeleteException;
import com.cg.onlineplantnursery.planter.exceptions.PlanterUpdateException;
import com.cg.onlineplantnursery.planter.repository.IPlanterRepository;

@Service
public class PlanterServiceImpl implements IPlanterService {

	@Autowired
	IPlanterRepository repository;

	@Transactional
	@Override
	public Planter addPlanter(Planter planter) {
		validatePlanter(planter);
		Planter saved = repository.save(planter);
		return saved;
	}

	@Override
	public Planter updatePlanter(Planter planter) {
		Integer id = planter.getPlanterId();
		boolean exists = repository.existsById(id);
		if (!exists) {
			throw new PlanterUpdateException("Planter does not exists");

		}
		
		planter.setPlanterShape("Cylinderical");

		return repository.save(planter);
	}

	@Override
	public Planter deletePlanter(Planter planter) {
		int id = planter.getPlanterId();

		boolean exists = repository.existsById(id);
		if (!exists) {
			throw new PlanterDeleteException("Planter does not exists");

		}

		repository.deleteById(id);
		return null;

	}

	@Override
	public Planter viewPlanter(int planterId) {
		Optional<Planter> optional = repository.findById(planterId);
		if (!optional.isPresent()) {
			throw new InvalidPlanterIdException("Planter is not found for this Id");
		}

		return optional.get();
	}

	@Override
	public List<Planter> viewPlanter(String planterShape) {

		List<Planter> planterList = repository.viewPlanter(planterShape);
		if (planterList.isEmpty()) {
			return null;
		}

		return planterList;

	}

	@Override
	public List<Planter> viewAllPlanters() {
		List<Planter> planterList = repository.viewAllPlanters();
		if (planterList.isEmpty()) {
			return null;
		}

		return planterList;
	}

	@Override
	public List<Planter> viewAllPlanters(double minCost, double maxCost) {
		
		List<Planter> planterList = repository.viewAllPlanters(minCost,maxCost);
		if (planterList.isEmpty()) {
			return null;
		}

		return planterList;
	}
	
	public void validatePlanter(Planter planter) {
		if(planter==null) {
			throw new InvalidPlanterException("Planter cannot be null");
		}
	}

}
