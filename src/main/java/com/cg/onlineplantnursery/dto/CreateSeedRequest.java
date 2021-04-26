package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateSeedRequest {
	@NotBlank(message = "Field cannot be empty")
	private String commonName;
	@NotBlank(message = "Field cannot be empty")
	private String bloomTime;
	@NotBlank(message = "Field cannot be empty")
	private String watering;
	@NotBlank(message = "Field cannot be empty")
	private String difficultyLevel;
	@NotBlank(message = "Field cannot be empty")
	private String temparature;
	@NotBlank(message = "Field cannot be empty")
	private String typeOfSeeds;
	@NotBlank(message = "Field cannot be empty")
	private String seedsDescription;
	@NotNull(message = "Field cannot be empty")
	private int seedsStock;
	@NotNull
	private double seedsCost;
	@NotNull(message = "Field cannot be empty")
	private int seedsPerPacket;

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

	public String getWatering() {
		return watering;
	}

	public void setWatering(String watering) {
		this.watering = watering;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getTemparature() {
		return temparature;
	}

	public void setTemparature(String temparature) {
		this.temparature = temparature;
	}

	public String getTypeOfSeeds() {
		return typeOfSeeds;
	}

	public void setTypeOfSeeds(String typeOfSeeds) {
		this.typeOfSeeds = typeOfSeeds;
	}

	public String getSeedsDescription() {
		return seedsDescription;
	}

	public void setSeedsDescription(String seedsDescription) {
		this.seedsDescription = seedsDescription;
	}

	public int getSeedsStock() {
		return seedsStock;
	}

	public void setSeedsStock(int seedsStock) {
		this.seedsStock = seedsStock;
	}

	public double getSeedsCost() {
		return seedsCost;
	}

	public void setSeedsCost(double seedsCost) {
		this.seedsCost = seedsCost;
	}

	public int getSeedsPerPacket() {
		return seedsPerPacket;
	}

	public void setSeedsPerPacket(int seedsPerPacket) {
		this.seedsPerPacket = seedsPerPacket;
	}

}
