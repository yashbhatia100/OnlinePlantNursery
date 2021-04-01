package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotNull;

public class UpdateOrderQuantityRequest {
	@NotNull
	private Integer bookingOrderId;
	@NotNull
	private int quantity;

	public Integer getBookingOrderId() {
		return bookingOrderId;
	}

	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
