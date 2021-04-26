package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotNull;

public class UpdatePlanterColorRequest {
	@NotNull(message = "Field cannot be empty")
	int planterId;
	@NotNull(message = "Field cannot be empty")
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
