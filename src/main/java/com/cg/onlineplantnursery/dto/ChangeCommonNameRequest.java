package com.cg.onlineplantnursery.dto;

public class ChangeCommonNameRequest {

	private int seedId;

	private String commonName;

	public int getSeedId() {
		return seedId;
	}

	public void setSeedId(int seedId) {
		this.seedId = seedId;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

}
