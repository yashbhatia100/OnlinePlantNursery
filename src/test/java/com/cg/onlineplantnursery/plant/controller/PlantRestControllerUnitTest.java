package com.cg.onlineplantnursery.plant.controller;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.onlineplantnursery.plant.dto.AddPlantRequest;
import com.cg.onlineplantnursery.plant.dto.DeletePlantRequest;
import com.cg.onlineplantnursery.plant.dto.PlantDetails;
import com.cg.onlineplantnursery.plant.dto.UpdatePlantPriceRequest;
import com.cg.onlineplantnursery.plant.dto.UpdatePlantStockRequest;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.plant.service.IPlantService;
import com.cg.onlineplantnursery.plant.util.PlantUtility;

@ExtendWith(MockitoExtension.class)
class PlantRestControllerUnitTest {

	@Mock
	IPlantService service;
	
	@Mock
	PlantUtility util;
	
	@Spy
	@InjectMocks
	PlantRestController controller;
	
	@Test
	void test_addPlant() {
		AddPlantRequest request = mock(AddPlantRequest.class);
		Plant saved = mock(Plant.class);
		when(service.addPlant(any(Plant.class))).thenReturn(saved);
		PlantDetails details = mock(PlantDetails.class);
		when(util.toDetails(saved)).thenReturn(details);
		PlantDetails result = controller.addPlant(request);
		Assertions.assertNotNull(result);
		Assertions.assertSame(details, result);	
		verify(service).addPlant(any(Plant.class));
		verify(util).toDetails(saved);
	}
	
	@Test
	void test_deletePlant() {
		Integer id = 1;
		DeletePlantRequest request = mock(DeletePlantRequest.class);
		Plant plant = mock(Plant.class);
		when(request.getPlantId()).thenReturn(id);
		when(service.viewPlant(id)).thenReturn(plant);
		controller.deletePlant(request);
		verify(service).deletePlant(plant);
	}
	
	@Test
	void test_updatePlantPrice() {
		Integer id = 1;
		UpdatePlantPriceRequest request = mock(UpdatePlantPriceRequest.class);
		Plant plant = mock(Plant.class);
		when(request.getPlantId()).thenReturn(id);
		when(request.getPlantCost()).thenReturn(70.0);
		when(service.viewPlant(id)).thenReturn(plant);
		when(service.updatePlant(plant)).thenReturn(plant);
		PlantDetails details = mock(PlantDetails.class);
		when(util.toDetails(plant)).thenReturn(details);
		PlantDetails result = controller.updatePlantPrice(request);
		Assertions.assertNotNull(result);
		Assertions.assertSame(details, result);
		verify(service).viewPlant(id);
		verify(service).updatePlant(plant);
		verify(util).toDetails(plant);
	}
	
	@Test
	void test_updatePlantStock() {
		Integer id = 1;
		UpdatePlantStockRequest request = mock(UpdatePlantStockRequest.class);
		Plant plant = mock(Plant.class);
		when(request.getPlantId()).thenReturn(id);
		when(request.getPlantsStock()).thenReturn(70);
		when(service.viewPlant(id)).thenReturn(plant);
		when(service.updatePlant(plant)).thenReturn(plant);
		PlantDetails details = mock(PlantDetails.class);
		when(util.toDetails(plant)).thenReturn(details);
		PlantDetails result = controller.updatePlantStock(request);
		Assertions.assertNotNull(result);
		Assertions.assertSame(details, result);
		verify(service).viewPlant(id);
		verify(service).updatePlant(plant);
		verify(util).toDetails(plant);
	}
	
	@Test
	void test_fetchById() {
		Integer id = 1;
		Plant plant = mock(Plant.class);
		when(service.viewPlant(id)).thenReturn(plant);
		PlantDetails details = mock(PlantDetails.class);
		when(util.toDetails(plant)).thenReturn(details);
		PlantDetails result = controller.fetchById(id);
		Assertions.assertNotNull(result);
		Assertions.assertSame(details, result);
		verify(service).viewPlant(id);
		verify(util).toDetails(plant);
	}
	
	@Test
	void test_fetchByName() {
		String commonName = "abc";
		Plant plant = mock(Plant.class);
		when(service.viewPlant(commonName)).thenReturn(plant);
		PlantDetails details = mock(PlantDetails.class);
		when(util.toDetails(plant)).thenReturn(details);
		PlantDetails result = controller.fetchByName(commonName);
		Assertions.assertNotNull(result);
		Assertions.assertSame(details, result);
		verify(service).viewPlant(commonName);
		verify(util).toDetails(plant);
	}
	
	@Test
	void test_fetchAllByType() {
		String typeOfPlant = "xyz";
		List<Plant> plantList = mock(List.class);
		when(service.viewAllPlants(typeOfPlant)).thenReturn(plantList);
		List<PlantDetails> desiredList = mock(List.class);
		when(util.toDetailList(plantList)).thenReturn(desiredList);
		List<PlantDetails> resultList = controller.fetchAllByType(typeOfPlant);
		Assertions.assertNotNull(resultList);
		Assertions.assertSame(desiredList, resultList);
		verify(service).viewAllPlants(typeOfPlant);
		verify(util).toDetailList(plantList);
	}
	
	@Test
	void test_fetchAll() {
		List<Plant> plantList = mock(List.class);
		when(service.viewAllPlants()).thenReturn(plantList);
		List<PlantDetails> desiredList = mock(List.class);
		when(util.toDetailList(plantList)).thenReturn(desiredList);
		List<PlantDetails> resultList = controller.fetchAll();
		Assertions.assertNotNull(resultList);
		Assertions.assertSame(desiredList, resultList);
		verify(service).viewAllPlants();
		verify(util).toDetailList(plantList);
	}
}
