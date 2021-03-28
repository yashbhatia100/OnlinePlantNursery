package com.cg.onlineplantnursery.customer.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private Integer customerId;
	private String customerName;
	private String customerEmail;
	private String username;
	private String password;
	//private Address address;
	
	public Customer() {
		
	}
	/*public Customer( String customerName,String customerEmail, String username, String password) { //Address address 
		//this.customerId=customerId;
		this.customerName=customerName;
		this.customerEmail=customerEmail;
		this.username=username;
		this.password=password;
		//this.address=address;
	}*/
	
	public Integer getCustomerId() {
		return customerId;
		
	}
	
	public void setCustomerId(Integer customerId) {
		this.customerId=customerId;
	}
	
	public String getCustomerName() {
		return customerName;
		
	}
	
	public void setCustomerName(String customerName) {
		this.customerName=customerName;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
		
	}
	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail=customerEmail;
	}
	
	public String getUsername() {
		return username;
		
	}
	
	public void setUsername(String username) {
		this.username=username;
	}
	
	public String getPassword() {
		return password;
		
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	/*
	public Address getAddress() {
		return address;
		
	}
	
	public void setAddress(Address address) {
		this.address=address;
	}
	*/
	
	@Override
	public int hashCode() {
		return customerId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		 if(obj==null || !(obj instanceof Customer)) {
			 return false;
		 }
		 Customer that=(Customer)obj;
		return this.customerId==that.customerId;
	}
	
}
