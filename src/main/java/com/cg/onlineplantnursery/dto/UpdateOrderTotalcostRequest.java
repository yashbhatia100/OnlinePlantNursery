package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotNull;

public class UpdateOrderTotalcostRequest {
	@NotNull
	private Integer bookingOrderId;
	@NotNull
	private double totalCost;

	public Integer getBookingOrderId() {
		return bookingOrderId;
	}

	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

}
