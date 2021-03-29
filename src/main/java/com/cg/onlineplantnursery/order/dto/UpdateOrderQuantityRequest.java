package com.cg.onlineplantnursery.order.dto;

public class UpdateOrderQuantityRequest {
	private Integer bookingOrderId;
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
