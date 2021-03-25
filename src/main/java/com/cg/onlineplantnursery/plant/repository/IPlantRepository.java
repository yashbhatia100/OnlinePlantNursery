package com.cg.onlineplantnursery.plant.repository;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineplantnursery.plant.entity.Plant;


public interface IPlantRepository {
	
	Plant save(Plant plant);
	boolean existsById(Integer id);
	Plant delete(Plant plant);
	Optional<Plant> findById(Integer id);
	List<Plant>findAll();
	Plant findPlantByCommonName(String commonName);
	boolean existsByCommonName(String commonName);
	List<Plant> findByTypeOfPlant(String typeOfPlant);
}
