package com.cg.onlineplantnursery.planter.dto;

public class UpdatePlanterStockRequest {
	int planterId;
	int planterStock;
	public int getPlanterId() {
		return planterId;
	}
	public void setPlanterId(int planterId) {
		this.planterId = planterId;
	}
	public int getPlanterStock() {
		return planterStock;
	}
	public void setPlanterStock(int planterStock) {
		this.planterStock = planterStock;
	}
	

}
