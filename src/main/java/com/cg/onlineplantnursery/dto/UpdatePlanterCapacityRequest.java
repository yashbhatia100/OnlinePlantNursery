package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotNull;

public class UpdatePlanterCapacityRequest {
	@NotNull(message = "Field cannot be empty")
	int planterId;
	@NotNull(message = "Field cannot be empty")
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
