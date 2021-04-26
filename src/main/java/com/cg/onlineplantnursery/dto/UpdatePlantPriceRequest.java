package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotNull;

public class UpdatePlantPriceRequest {

	@NotNull(message = "Field cannot be empty")
	private Integer plantId;
	@NotNull(message = "Field cannot be empty")
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
