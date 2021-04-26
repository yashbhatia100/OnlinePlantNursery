package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotNull;

public class UpdatePlanterHeightRequest {
	@NotNull(message = "Field cannot be empty")
	int planterId;
	@NotNull(message = "Field cannot be empty")
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
