package com.cg.onlineplantnursery.customer.dto;

public class ChangeCustomerPasswordRequest {
	private int CustomerId;
public int getCustomerId() {
	return CustomerId;
}
public void setCustomerId(int customerId) {
	CustomerId = customerId;
}
private String password;
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
