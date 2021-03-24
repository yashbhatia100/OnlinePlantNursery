package com.cg.onlineplantnursery.plant.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.plant.repository.IPlantRepository;

@ExtendWith(MockitoExtension.class)
public class PlantServiceImplTest {

	@Mock
	IPlantRepository repository;
	
	@Spy
	@InjectMocks
	PlantServiceImpl service;
	
	/*
	 * Scenario: when plant object is added successfully
	 */
	@Test
	public void test_addPlant_1() {
		Integer plantId=1;
		Integer plantHeight=10;
		String plantSpread="fifty";
		String commonName="plant1";
		String bloomTime="two months";
		String medicinalOrCulinaryUse="boosts immunity";
		String difficultyLevel="moderate";
		String temperature="cool";
		String typeOfPlant="shrub";
		String plantDescription="garden plant";
		Integer plantsStock=10;
		double plantCost =100;
		
		Plant plant = new Plant(plantId,plantHeight, plantSpread, commonName, bloomTime, 
						medicinalOrCulinaryUse, difficultyLevel, temperature, typeOfPlant,
						plantDescription, plantsStock,plantCost);
		
		Mockito.when(repository.addPlant(plant)).thenReturn(plant);
		
		Plant result = service.addPlant(plant);
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals(plant, result);
	}
	
	/*
	 * Scenario: when plant object is updated successfully
	 */
	@Test
	public void test_updatePlant_1() {
		Integer plantId=1;
		Integer plantHeight=10;
		String plantSpread="fifty";
		String commonName="plant1";
		String bloomTime="two months";
		String medicinalOrCulinaryUse="boosts immunity";
		String difficultyLevel="moderate";
		String temperature="cool";
		String typeOfPlant="shrub";
		String plantDescription="garden plant";
		Integer plantsStock=10;
		double plantCost =100;
		
		Plant plant = new Plant(plantId,plantHeight, plantSpread, commonName, bloomTime, 
						medicinalOrCulinaryUse, difficultyLevel, temperature, typeOfPlant,
						plantDescription, plantsStock,plantCost);
	
		Mockito.doReturn(plant).when(service).addPlant(plant);
		
		Plant result = service.addPlant(plant);
		
		Mockito.when(service.updatePlant(plant)).thenReturn(plant);
		
		result.setPlantId(2);
		result.setPlantHeight(20);
		result.setPlantSpread("sixty");
		result.setDifficultyLevel("easy");
		result.setPlantCost(200);
		
		Plant updated = service.updatePlant(result);
		
		Assertions.assertNotNull(updated);
		Assertions.assertEquals(2, updated.getPlantId());
		Assertions.assertEquals(20, updated.getPlantHeight());
		Assertions.assertEquals("sixty", updated.getPlantSpread());
		Assertions.assertEquals("easy", updated.getDifficultyLevel());
		Assertions.assertEquals(200, updated.getPlantCost());
	}
}
