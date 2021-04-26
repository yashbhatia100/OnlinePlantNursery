package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotNull;

public class UpdatePlanterDrainageHolesRequest {
	@NotNull(message = "Field cannot be empty")
	int planterId;
	@NotNull(message = "Field cannot be empty")
	int drainageHoles;

	public int getPlanterId() {
		return planterId;
	}

	public void setPlanterId(int planterId) {
		this.planterId = planterId;
	}

	public int getDrainageHoles() {
		return drainageHoles;
	}

	public void setDrainageHoles(int drainageHoles) {
		this.drainageHoles = drainageHoles;
	}

}
