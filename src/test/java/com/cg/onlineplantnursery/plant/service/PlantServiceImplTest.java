package com.cg.onlineplantnursery.plant.service;

import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.onlineplantnursery.exceptions.AddPlantException;
import com.cg.onlineplantnursery.exceptions.PlantNotFoundException;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.plant.repository.IPlantRepository;

@ExtendWith(MockitoExtension.class)
class PlantServiceImplTest {

	@Mock
	IPlantRepository repository;
	
	@Spy
	@InjectMocks
	PlantServiceImpl service;
	
	/*
	 * Scenario: when plant object is added successfully
	 */
	@Test
	void test_addPlant_1() {
		
		Plant plant = mock(Plant.class);
		Plant saved = mock(Plant.class);
		Mockito.when(repository.save(plant)).thenReturn(saved);
		Plant result = service.addPlant(plant);
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals(saved, result);
		verify(repository).save(plant);
	}
	
	/*
	 * Scenario: when passed plant object is null
	 */
	@Test
	void test_addPlant_2() {
		
		Plant plant = null;
		Executable executable=()->service.addPlant(plant);
		
		Assertions.assertThrows(AddPlantException.class, executable);
		verify(repository,never()).save(plant);
	}
	
	/*
	 * Scenario: when plant object to be updated exists in store and is updated successfully
	 */
	@Test
	void test_updatePlant_1() {
		
		Integer id=2;
		Plant plant = mock(Plant.class);
		Mockito.when(plant.getPlantId()).thenReturn(id);
		Mockito.when(repository.existsById(id)).thenReturn(true);
		Mockito.when(repository.save(plant)).thenReturn(plant);
		Plant result = service.updatePlant(plant);
		
		Assertions.assertNotNull(result);
		Assertions.assertSame(plant, result);
		verify(repository).save(plant);
	}
	
	/*
	 *  Scenario: when plant object to be updated does not exist in store
	 */
	@Test
	void test_updatePlant_2() {
		
		Integer id = 1;
		Plant plant = mock(Plant.class);
		Mockito.when(plant.getPlantId()).thenReturn(id);
		Mockito.when(repository.existsById(id)).thenReturn(false);
		Executable executable =()->service.updatePlant(plant);
		
		Assertions.assertThrows(PlantNotFoundException.class,executable);
		verify(repository,never()).save(plant);
	}
	
	/*
	 *  Scenario: when plant object to be deleted does not exist in store
	 */
	@Test
	void test_deletePlant_1() {
		
		Integer id = 1;
		Plant plant = mock(Plant.class);
		Mockito.when(plant.getPlantId()).thenReturn(id);
		Mockito.when(repository.existsById(id)).thenReturn(false);
		Executable executable =()->service.deletePlant(plant);
		
		Assertions.assertThrows(PlantNotFoundException.class,executable);
		verify(repository,never()).delete(plant);
	}
	
	/*
	 *  Scenario: when plant object to be deleted exists in store and is deleted successfully
	 */
	@Test
	void test_deletePlant_2() {
		
		Integer id=2;
		Plant plant = mock(Plant.class);
		Mockito.when(plant.getPlantId()).thenReturn(id);
		Mockito.when(repository.existsById(id)).thenReturn(true);
		Plant result = service.deletePlant(plant);
		
		Assertions.assertNull(result);
		verify(repository).delete(plant);
	}
		
	/*
	 *  Scenario: when plant object to view by id does not exist in store
	 */
	@Test
	void test_viewById_1() {
		
		Integer id=1;
		Optional<Plant> optional = Optional.empty();
		Mockito.when(repository.findById(id)).thenReturn(optional);
		Executable executable=()->service.viewPlant(id);
		
		Assertions.assertThrows(PlantNotFoundException.class, executable);
	}
	
	/*
	 *  Scenario: when plant object to view by id exists in store and is fetched successfully
	 */
	@Test
	void test_viewById_2() {
		
		Integer id=2;
		Plant fetched = mock(Plant.class);
		Optional<Plant> optional = Optional.of(fetched);
		Mockito.when(repository.findById(id)).thenReturn(optional);
		Plant result = service.viewPlant(id);
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals(fetched, result);
	}
	
	/*
	 *  Scenario: when plant object to view by common name does not exist in store
	 */
	@Test
	void test_viewByCommonName_1() {
		
		String commonName = "abcd";
		Mockito.when(repository.existsByCommonName(commonName)).thenReturn(false);
		Executable executable =()->service.viewPlant(commonName);
		
		Assertions.assertThrows(PlantNotFoundException.class, executable);
		verify(repository,never()).findByCommonName(commonName);
	}
	
	/*
	 *  Scenario: when plant object to view by common name exists in store and is fetched successfully 
	 */
	@Test
	void test_viewByCommonName_2() {
		
		String commonName = "abcd";
		Plant fetched = mock(Plant.class);
		Mockito.when(repository.existsByCommonName(commonName)).thenReturn(true);
		Mockito.when(repository.findByCommonName(commonName)).thenReturn(fetched);
		Plant result = service.viewPlant(commonName);
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals(fetched, result);
		verify(repository).findByCommonName(commonName);
	}
	
	/*
	 *  Scenario: when all the plant objects are fetched successfully
	 */
	@Test 
	void test_viewAllPlants_1(){
		
		List<Plant> fetchedList = mock(List.class);
		Mockito.when(repository.findAll()).thenReturn(fetchedList);
		Mockito.when(fetchedList.isEmpty()).thenReturn(false);
		List<Plant> resultList = service.viewAllPlants();
		
		Assertions.assertNotNull(resultList);
		Assertions.assertEquals(fetchedList, resultList);
	}
	
	/*
	 *  Scenario: when plant objects doesnt exist in store and list is empty
	 */
	@Test
	void test_viewAllPlants_2() {
		
		List<Plant> fetchedList = mock(List.class);
		Mockito.when(repository.findAll()).thenReturn(fetchedList);
		Mockito.when(fetchedList.isEmpty()).thenReturn(true);
		Executable executable =()->service.viewAllPlants();
		
		Assertions.assertThrows(PlantNotFoundException.class,executable);
	}

	/*
	 *  Scenario: when plant objects of specified type does not exist in store
	 */
	@Test
	void test_viewPlantsByType_1() {
		
		String commonName="abcd";
		List<Plant> fetchedList = mock(List.class);
		//Mockito.when(repository.findAllByType(commonName)).thenReturn(fetchedList);
		//Mockito.when(fetchedList.isEmpty()).thenReturn(true);
		Executable executable =()->service.viewAllPlants();
		
		Assertions.assertThrows(PlantNotFoundException.class, executable);
	}
	
	/*
	 *  Scenario: when plant objects of specified type exists and fetched successfully
	 */
	@Test
	void test_viewAllPlantsByType_2(){
		
		String commonName="abcd";
		List<Plant> fetchedList = mock(List.class);
		Mockito.when(repository.findAllByTypeOfPlant(commonName)).thenReturn(fetchedList);
		Mockito.when(fetchedList.isEmpty()).thenReturn(false);
		List<Plant> resultList = service.viewAllPlants(commonName);
		
		Assertions.assertNotNull(resultList);
		Assertions.assertEquals(fetchedList, resultList);
	}
}
