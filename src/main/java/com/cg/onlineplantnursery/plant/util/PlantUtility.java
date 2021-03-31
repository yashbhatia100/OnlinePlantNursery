package com.cg.onlineplantnursery.plant.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.onlineplantnursery.plant.dto.PlantDetails;
import com.cg.onlineplantnursery.plant.entity.Plant;

@Component
public class PlantUtility {

	//converting Plant entity object to PlantDetails DTO object
	public PlantDetails toDetails(Plant plant) {
		
		PlantDetails details = new PlantDetails();
		details.setPlantHeight(plant.getPlantHeight());
		details.setPlantSpread(plant.getPlantSpread());
		details.setCommonName(plant.getCommonName());
		details.setBloomTime(plant.getBloomTime());
		details.setMedicinalOrCulinaryUse(plant.getMedicinalOrCulinaryUse());
		details.setDifficultyLevel(plant.getDifficultyLevel());
		details.setTemperature(plant.getTemperature());
		details.setTypeOfPlant(plant.getTypeOfPlant());
		details.setPlantDescription(plant.getPlantDescription());
		details.setPlantsStock(plant.getPlantsStock());
		details.setPlantCost(plant.getPlantCost());
		
		return details;
	}
	
	//converting a List of Plant entity objects to a List of PlantDetails DTO objects
	public List<PlantDetails> toDetailList (List<Plant> plantList){
		
		List<PlantDetails> desiredList = new ArrayList<>();
		for(Plant plant:plantList) {
			desiredList.add(toDetails(plant));
		}
		return desiredList;
	}
}
