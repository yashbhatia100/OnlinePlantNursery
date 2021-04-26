package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PlantDetails {
	@NotNull(message = "Field cannot be empty")
	private Integer plantId;
	@NotNull(message = "Field cannot be empty")
	private Integer plantHeight;
	@NotBlank(message = "Field cannot be empty")
	private String plantSpread;
	@NotBlank(message = "Field cannot be empty")
	private String commonName;
	@NotBlank(message = "Field cannot be empty")
	private String bloomTime;
	@NotBlank(message = "Field cannot be empty")
	private String medicinalOrCulinaryUse;
	@NotBlank(message = "Field cannot be empty")
	private String difficultyLevel;
	@NotBlank(message = "Field cannot be empty")
	private String temperature;
	@NotBlank(message = "Field cannot be empty")
	private String typeOfPlant;
	@NotBlank(message = "Field cannot be empty")
	private String plantDescription;
	@NotBlank(message = "Field cannot be empty")
	private Integer plantsStock;
	@NotNull(message = "Field cannot be empty")
	private double plantCost;

	public Integer getPlantId() {
		return plantId;
	}

	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}
	public Integer getPlantHeight() {
		return plantHeight;
	}

	public void setPlantHeight(Integer plantHeight) {
		this.plantHeight = plantHeight;
	}

	public String getPlantSpread() {
		return plantSpread;
	}

	public void setPlantSpread(String plantSpread) {
		this.plantSpread = plantSpread;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getBloomTime() {
		return bloomTime;
	}

	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}

	public String getMedicinalOrCulinaryUse() {
		return medicinalOrCulinaryUse;
	}

	public void setMedicinalOrCulinaryUse(String medicinalOrCulinaryUse) {
		this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getTypeOfPlant() {
		return typeOfPlant;
	}

	public void setTypeOfPlant(String typeOfPlant) {
		this.typeOfPlant = typeOfPlant;
	}

	public String getPlantDescription() {
		return plantDescription;
	}

	public void setPlantDescription(String plantDescription) {
		this.plantDescription = plantDescription;
	}

	public Integer getPlantsStock() {
		return plantsStock;
	}

	public void setPlantsStock(Integer plantsStock) {
		this.plantsStock = plantsStock;
	}

	public double getPlantCost() {
		return plantCost;
	}

	public void setPlantCost(double plantCost) {
		this.plantCost = plantCost;
	}
}
