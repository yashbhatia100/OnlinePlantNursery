package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotNull;

public class DeletePlantRequest {
	@NotNull(message = "Field cannot be empty")
	private Integer plantId;

	public Integer getPlantId() {
		return plantId;
	}

	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}
}
