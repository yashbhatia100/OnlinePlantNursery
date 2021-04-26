package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotNull;

public class ChangeSeedsCostRequest {
	@NotNull(message = "Field cannot be empty")
	private int seedId;
	@NotNull(message = "Field cannot be empty")
	private double seedsCost;

	public int getSeedId() {
		return seedId;
	}

	public void setSeedId(int seedId) {
		this.seedId = seedId;
	}

	public double getSeedsCost() {
		return seedsCost;
	}

	public void setSeedsCost(double seedsCost) {
		this.seedsCost = seedsCost;
	}

}
