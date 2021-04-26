
package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChangeCustomerPasswordRequest {
	@NotNull(message = "Field cannot be empty")
	private int customerId;
	@NotBlank(message = "Field cannot be empty")
	private String password;

	@NotBlank(message = "Field cannot be empty")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
