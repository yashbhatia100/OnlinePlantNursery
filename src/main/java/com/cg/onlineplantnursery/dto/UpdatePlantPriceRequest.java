package com.cg.onlineplantnursery.dto;

public class UpdatePlantPriceRequest {

	private Integer plantId;
	private double plantCost;
	
	
	public Integer getPlantId() {
		return plantId;
	}
	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}
	public double getPlantCost() {
		return plantCost;
	}
	public void setPlantCost(double plantCost) {
		this.plantCost = plantCost;
	}
}
