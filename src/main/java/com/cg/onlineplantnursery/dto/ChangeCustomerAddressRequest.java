package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChangeCustomerAddressRequest {
	@NotNull(message = "Field cannot be empty")
	private int customerId;
	@NotBlank(message = "Field cannot be empty")
	private String houseNo;
	@NotBlank(message = "Field cannot be empty")
	private String colony;
	@NotBlank(message = "Field cannot be empty")
	private String city;
	@NotBlank(message = "Field cannot be empty")
	private String state;
	@NotNull(message = "Field cannot be empty")
	private int pincode;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getColony() {
		return colony;
	}

	public void setColony(String colony) {
		this.colony = colony;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
