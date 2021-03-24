package com.cg.onlineplantnursery.plant.repository;

import java.util.List;

import com.cg.onlineplantnursery.plant.entity.Plant;

public interface IPlantRepository {
	Plant addPlant(Plant plant);

	Plant updatePlant(Plant plant);

	Plant deletePlant(Plant plant);

	Plant viewPlant(int plantId);

	Plant viewPlant(String commonName);

	List<Plant> viewAllPlants();

	List<Plant> viewAllPlants(String typeOfPlant);
	
}
