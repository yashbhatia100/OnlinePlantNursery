package com.cg.onlineplantnursery.seed.dto;

public class ChangeSeedsStockRequest {

	private int seedId;

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
