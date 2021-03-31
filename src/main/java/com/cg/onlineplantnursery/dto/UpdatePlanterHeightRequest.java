package com.cg.onlineplantnursery.dto;

public class UpdatePlanterHeightRequest {
	int planterId;
	private float planterHeight;
	public int getPlanterId() {
		return planterId;
	}
	public void setPlanterId(int planterId) {
		this.planterId = planterId;
	}
	public float getPlanterHeight() {
		return planterHeight;
	}
	public void setPlanterHeight(float planterHeight) {
		this.planterHeight = planterHeight;
	}
	

}
