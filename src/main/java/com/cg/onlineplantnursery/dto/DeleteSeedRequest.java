package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotNull;

public class DeleteSeedRequest {
	@NotNull(message = "Field cannot be empty")
	private int seedId;

	public int getSeedId() {
		return seedId;
	}

	public void setSeedId(int seedId) {
		this.seedId = seedId;
	}

}
