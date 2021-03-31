package com.cg.onlineplantnursery.planter.dto;

public class UpdatePlanterColorRequest {
	int planterId;
	int planterColor;
	public int getPlanterId() {
		return planterId;
	}
	public void setPlanterId(int planterId) {
		this.planterId = planterId;
	}
	public int getPlanterColor() {
		return planterColor;
	}
	public void setPlanterColor(int planterColor) {
		this.planterColor = planterColor;
	}

}
