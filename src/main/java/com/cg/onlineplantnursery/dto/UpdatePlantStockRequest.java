package com.cg.onlineplantnursery.dto;

public class UpdatePlantStockRequest {

	private Integer plantId;
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
