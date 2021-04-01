package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChangeCustomerEmailRequest {
	@NotNull
	private Integer id;
	@NotBlank
	private String customerEmail;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
}
