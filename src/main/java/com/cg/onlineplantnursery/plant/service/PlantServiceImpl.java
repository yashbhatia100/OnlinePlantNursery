package com.cg.onlineplantnursery.plant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.plant.repository.IPlantRepository;

@Service
public class PlantServiceImpl implements IPlantService {

	@Autowired
	IPlantRepository repository;
	
	@Override
	public Plant addPlant(Plant plant) {
		Plant plant1 = repository.addPlant(plant);
		return plant1;
	}
	
	@Override
	public Plant updatePlant(Plant plant) {
		Plant plant1 = repository.updatePlant(plant);
		return plant1;
	}
	
	@Override
	public Plant deletePlant(Plant plant) {
		return null;
	}
	
	@Override
	public Plant viewPlant(int plantId) {
		return null;
	}

	@Override
	public Plant viewPlant(String commonName) {
		return null;
	}

	@Override
	public List<Plant> viewAllPlants(){
		return null;
	}

	@Override
	public List<Plant> viewAllPlants(String typeOfPlant){
		return null;
	}
}
