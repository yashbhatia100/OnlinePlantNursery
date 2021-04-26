package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChangeCommonNameRequest {
	@NotNull(message = "Field cannot be empty")
	private int seedId;
	@NotBlank(message = "Field cannot be empty")
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
