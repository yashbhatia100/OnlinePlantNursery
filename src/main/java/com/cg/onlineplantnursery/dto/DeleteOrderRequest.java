package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotNull;

public class DeleteOrderRequest {
	@NotNull
	private Integer bookingOrderId;

	public Integer getBookingOrderId() {
		return bookingOrderId;
	}

	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}
}
