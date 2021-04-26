package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddCustomerRequest {
	@NotBlank(message = "Field cannot be empty")
	private String customerName;
	@NotBlank(message = "Field cannot be empty")
	private String customerEmail;
	@NotBlank(message = "Field cannot be empty")
	private String username;
	@NotBlank(message = "Field cannot be empty")
	private String password;
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

	
	public String getCustomerName() {
		return customerName;

	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;

	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getUsername() {
		return username;

	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;

	}

	public void setPassword(String password) {
		this.password = password;
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
