package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotNull;

public class DeleteCustomerRequest {
	@NotNull
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
