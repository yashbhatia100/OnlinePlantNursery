package com.cg.onlineplantnursery.dto;

public class AddPlantRequest {

	private Integer plantHeight;
	private String plantSpread;
	private String commonName;
	private String bloomTime;
	private String medicinalOrCulinaryUse;
	private String difficultyLevel;
	private String temperature;
	private String typeOfPlant;
	private String plantDescription;
	private Integer plantsStock;
	private double plantCost;
	
	
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
	
	
}
