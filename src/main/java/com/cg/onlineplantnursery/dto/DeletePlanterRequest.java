package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotNull;

public class DeletePlanterRequest {
	@NotNull(message = "Field cannot be empty")
	private Integer planterId;

	public Integer getPlanterId() {
		return planterId;
	}

	public void setPlanterId(Integer planterId) {
		this.planterId = planterId;
	}

}
