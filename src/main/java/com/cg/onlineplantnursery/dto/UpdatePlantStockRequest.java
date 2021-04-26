package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotNull;

public class UpdatePlantStockRequest {
	@NotNull(message = "Field cannot be empty")
	private Integer plantId;
	@NotNull(message = "Field cannot be empty")
	private Integer plantsStock;

	public Integer getPlantId() {
		return plantId;
	}

	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}

	public Integer getPlantsStock() {
		return plantsStock;
	}

	public void setPlantsStock(Integer plantsStock) {
		this.plantsStock = plantsStock;
	}

}
