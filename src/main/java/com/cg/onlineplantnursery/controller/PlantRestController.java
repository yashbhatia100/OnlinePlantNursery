package com.cg.onlineplantnursery.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.dto.AddPlantRequest;
import com.cg.onlineplantnursery.dto.DeletePlantRequest;
import com.cg.onlineplantnursery.dto.PlantDetails;
import com.cg.onlineplantnursery.dto.UpdatePlantPriceRequest;
import com.cg.onlineplantnursery.dto.UpdatePlantStockRequest;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.plant.service.IPlantService;
import com.cg.onlineplantnursery.util.PlantUtility;

@Validated
@RequestMapping("/plants")
@RestController
public class PlantRestController {

	@Autowired
	private IPlantService service;

	@Autowired
	private PlantUtility util;

	/*
	 * Rest controller for adding a plant object to database Calls :
	 * service.addPlant() and util.toDetails()
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public PlantDetails addPlant(@RequestBody @Valid AddPlantRequest requestBody) {

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

	/*
	 * Rest controller for deleting a plant object from database Calls :
	 * service.viewPlant() and service.deletePlant()
	 */
	@ResponseStatus(HttpStatus.GONE)
	@DeleteMapping("/delete")
	public String deletePlant(@RequestBody @Valid DeletePlantRequest requestBody) {

		Integer plantId = requestBody.getPlantId();
		Plant plant = service.viewPlant(plantId);
		service.deletePlant(plant);
		return "Plant with id " + plantId + " is deleted.";
	}

	/*
	 * Rest controller for updating a plant object price in database Calls :
	 * service.viewPlant(), service.updatePlant() and util.toDetails()
	 */
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping("/updateprice")
	public PlantDetails updatePlantPrice(@RequestBody @Valid UpdatePlantPriceRequest requestBody) {

		Integer plantId = requestBody.getPlantId();
		Plant plant = service.viewPlant(plantId);
		plant.setPlantCost(requestBody.getPlantCost());
		Plant updated = service.updatePlant(plant);
		PlantDetails details = util.toDetails(updated);
		return details;
	}

	/*
	 * Rest controller for updating a plant object stock in database Calls :
	 * service.viewPlant(), service.updatePlant() and util.toDetails()
	 */
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping("/updatestock")
	public PlantDetails updatePlantStock(@RequestBody @Valid UpdatePlantStockRequest requestBody) {

		Integer plantId = requestBody.getPlantId();
		Plant plant = service.viewPlant(plantId);
		plant.setPlantsStock(requestBody.getPlantsStock());
		Plant updated = service.updatePlant(plant);
		PlantDetails details = util.toDetails(updated);
		return details;
	}

	/*
	 * Rest controller for fetching a plant object from database by ID Calls :
	 * service.viewPlant() and util.toDetails()
	 */
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("/fetch/byid/{id}")
	public PlantDetails fetchById(@PathVariable("id") @NotNull Integer plantId) {

		Plant plant = service.viewPlant(plantId);
		PlantDetails details = util.toDetails(plant);
		return details;
	}

	/*
	 * Rest controller for fetching a plant object from database by Name Calls :
	 * service.viewPlant() and util.toDetails()
	 */
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("/fetch/byname/{name}")
	public PlantDetails fetchByName(@PathVariable("name") @NotBlank String commonName) {

		Plant plant = service.viewPlant(commonName);
		PlantDetails details = util.toDetails(plant);
		return details;
	}

	/*
	 * Rest controller for fetching all plant objects from database by Type Calls :
	 * service.viewAllPlants() and util.toDetailList()
	 */
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("/fetch/bytype/{type}")
	public List<PlantDetails> fetchAllByType(@PathVariable("type") @NotBlank String typeOfPlant) {

		List<Plant> plantList = service.viewAllPlants(typeOfPlant);
		List<PlantDetails> desiredList = util.toDetailList(plantList);
		return desiredList;
	}

	/*
	 * Rest controller for fetching all plant objects from database Calls :
	 * service.viewAllPlants() and util.toDetailList()
	 */
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("/fetch")
	public List<PlantDetails> fetchAll() {

		List<Plant> plantList = service.viewAllPlants();
		List<PlantDetails> desiredList = util.toDetailList(plantList);
		return desiredList;
	}

}
