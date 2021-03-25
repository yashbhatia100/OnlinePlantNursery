package com.cg.onlineplantnursery.plant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.exceptions.AddPlantException;
import com.cg.onlineplantnursery.exceptions.PlantNotFoundException;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.plant.repository.IPlantRepository;

@Service
public class PlantServiceImpl implements IPlantService {

	@Autowired
	private IPlantRepository repository;
	
	// Adding a plant object to store 
	@Override
	public Plant addPlant(Plant plant) {
		
		if(plant == null) {
			throw new AddPlantException("No plant passed!");
		}
		return repository.save(plant);
	}
	
	// Updating a plant object present in store
	@Override
	public Plant updatePlant(Plant plant) {
		
		Integer id = plant.getPlantId();
		boolean exists = repository.existsById(id);
		if(!exists) {
			throw new PlantNotFoundException("Plant does not exist");
		}
		return repository.save(plant);
	}
	
	// Deleting a plant object from store
	@Override
	public Plant deletePlant(Plant plant) {
		
		Integer id = plant.getPlantId();
		boolean exists = repository.existsById(id);
		if(!exists) {
			throw new PlantNotFoundException("Plant does not exist");
		}
		return repository.delete(plant);
	}
	
	// Fetching a plant object from store by ID
	@Override
	public Plant viewPlant(int plantId) {
		
		Optional<Plant> optional = repository.findById(plantId);
		if(!optional.isPresent()) {
			throw new PlantNotFoundException("Plant does not exist");
		}
		return optional.get();		
	}

	// Fetching a plant object from store by Common Name
	@Override
	public Plant viewPlant(String commonName) {
		
		boolean exists = repository.existsByName(commonName);
		if(!exists) {
			throw new PlantNotFoundException("Plant does not exist!");
		}
		return repository.findByName(commonName);
	}

	// Fetching all plant objects from store
	@Override
	public List<Plant> viewAllPlants(){
		
		List<Plant> plantList = repository.findAll();
		if(plantList.isEmpty()) {
			throw new PlantNotFoundException("No plants found!");
		}
		return plantList;
	}

	// Fetching all plant objects based on a particular type from store
	@Override
	public List<Plant> viewAllPlants(String typeOfPlant){
		
		List<Plant> plantList = repository.findAllByType(typeOfPlant);
		if(plantList.isEmpty()) {
			throw new PlantNotFoundException("No plants found!");
		}
		return plantList;
	}

}
