package com.cg.onlineplantnursery.plant.repository;

import java.util.List;
import java.util.Optional;

import com.cg.onlineplantnursery.plant.entity.Plant;


public interface IPlantRepository {
	
	Plant save(Plant plant);
	boolean existsById(Integer id);
	Plant delete(Plant plant);
	Optional<Plant> findById(Integer id);
	List<Plant> findAll();
	Plant findByName(String commonName);
	boolean existsByName(String commonName);
	List<Plant> findAllByType(String typeOfPlant);
}
