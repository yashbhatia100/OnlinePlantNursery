package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChangeSeedsStockRequest {
	@NotNull
	private int seedId;
	@NotNull
	private int seedsStock;

	public int getSeedId() {
		return seedId;
	}

	public void setSeedId(int seedId) {
		this.seedId = seedId;
	}

	public int getSeedsStock() {
		return seedsStock;
	}

	public void setSeedsStock(int seedsStock) {
		this.seedsStock = seedsStock;
	}

}
