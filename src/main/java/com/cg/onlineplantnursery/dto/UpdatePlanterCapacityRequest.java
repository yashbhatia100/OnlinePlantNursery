package com.cg.onlineplantnursery.dto;

public class UpdatePlanterCapacityRequest {
	int planterId;
	int planterCapacity;
	public int getPlanterId() {
		return planterId;
	}
	public void setPlanterId(int planterId) {
		this.planterId = planterId;
	}
	public int getPlanterCapacity() {
		return planterCapacity;
	}
	public void setPlanterCapacity(int planterCapacity) {
		this.planterCapacity = planterCapacity;
	}
	

}
