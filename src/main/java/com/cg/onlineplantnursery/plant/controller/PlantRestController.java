package com.cg.onlineplantnursery.plant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.plant.dto.AddPlantRequest;
import com.cg.onlineplantnursery.plant.dto.DeletePlantRequest;
import com.cg.onlineplantnursery.plant.dto.PlantDetails;
import com.cg.onlineplantnursery.plant.dto.UpdatePlantPriceRequest;
import com.cg.onlineplantnursery.plant.dto.UpdatePlantStockRequest;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.plant.service.IPlantService;
import com.cg.onlineplantnursery.plant.util.PlantUtility;

@RequestMapping("/plants")
@RestController
public class PlantRestController {

	@Autowired
	private IPlantService service;
	
	@Autowired
	private PlantUtility util;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/addplant")
	public PlantDetails addPlant(@RequestBody AddPlantRequest requestBody) {
		
		Plant plant = new Plant();
		plant.setPlantHeight(requestBody.getPlantHeight());
		plant.setPlantSpread(requestBody.getPlantSpread());
		plant.setCommonName(requestBody.getCommonName());
		plant.setBloomTime(requestBody.getBloomTime());
		plant.setMedicinalOrCulinaryUse(requestBody.getMedicinalOrCulinaryUse());
		plant.setDifficultyLevel(requestBody.getDifficultyLevel());
		plant.setTemperature(requestBody.getTemperature());
		plant.setTypeOfPlant(requestBody.getTypeOfPlant());
		plant.setPlantDescription(requestBody.getPlantDescription());
		plant.setPlantsStock(requestBody.getPlantsStock());
		plant.setPlantCost(requestBody.getPlantCost());
		
		Plant saved = service.addPlant(plant);
		PlantDetails details = util.toDetails(saved);
		return details;
	}
	
	@ResponseStatus(HttpStatus.GONE)
	@DeleteMapping("/deleteplant")
	public String deletePlant(@RequestBody DeletePlantRequest requestBody) {
		
		Integer plantId = requestBody.getPlantId();
		Plant plant = service.viewPlant(plantId);
		service.deletePlant(plant);
		return "Plant with id "+plantId+" is deleted.";
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping("/updateplantprice")
	public PlantDetails updatePlantPrice(@RequestBody UpdatePlantPriceRequest requestBody) {
		
		Integer plantId = requestBody.getPlantId();
		Plant plant = service.viewPlant(plantId);
		plant.setPlantCost(requestBody.getPlantCost());
		Plant updated = service.updatePlant(plant);
		PlantDetails details = util.toDetails(updated);
		return details;
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping("/updateplantstock")
	public PlantDetails updatePlantStock(@RequestBody UpdatePlantStockRequest requestBody) {
		
		Integer plantId = requestBody.getPlantId();
		Plant plant = service.viewPlant(plantId);
		plant.setPlantsStock(requestBody.getPlantsStock());
		Plant updated = service.updatePlant(plant);
		PlantDetails details = util.toDetails(updated);
		return details;
	}
	
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("/viewplantbyid/{id}")
	public PlantDetails fetchById(@PathVariable("id") Integer plantId ) {
		
		Plant plant = service.viewPlant(plantId);
		PlantDetails details = util.toDetails(plant);
		return details;
	}
	
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("/viewplantbyname/{name}")
	public PlantDetails fetchByName(@PathVariable("name") String commonName ) {
		
		Plant plant = service.viewPlant(commonName);
		PlantDetails details = util.toDetails(plant);
		return details;
	}
	
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("/viewplantsbytype/{type}")
	public List<PlantDetails> fetchAllByType(@PathVariable("type") String typeOfPlant ) {
		
		List<Plant> plantList = service.viewAllPlants(typeOfPlant);
		List<PlantDetails> desiredList = util.toDetailList(plantList);
		return desiredList;
	}
	
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("/viewallplants")
	public List<PlantDetails> fetchAll() {
		
		List<Plant> plantList = service.viewAllPlants();
		List<PlantDetails> desiredList = util.toDetailList(plantList);
		return desiredList;
	}
	
	
}
