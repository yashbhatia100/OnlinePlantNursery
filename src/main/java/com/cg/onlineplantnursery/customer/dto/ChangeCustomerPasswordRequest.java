package com.cg.onlineplantnursery.customer.dto;

public class ChangeCustomerPasswordRequest {
	private int customerId;
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
private String password;
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
