package com.cg.onlineplantnursery.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrderDetails {
	@NotNull(message = "Field cannot be empty")
	private Integer bookingOrderId;
	@NotBlank(message = "Field cannot be empty")
	private String orderDate;
	@NotBlank(message = "Field cannot be empty")
	private String transactionMode;
	@NotNull(message = "Field cannot be empty")
	private int quantity;
	@NotNull(message = "Field cannot be empty")
	private double totalCost;
	@NotNull(message = "Field cannot be empty")
	private Integer planterId;
	@NotNull(message = "Field cannot be empty")
	private double planterCost;
	@NotNull(message = "Field cannot be empty")
	private Integer plantId;
	@NotBlank(message = "Field cannot be empty")
	private String plantCommonName;

	private Integer seedId;

	private String seedCommonName;

	public Integer getBookingOrderId() {
		return bookingOrderId;
	}

	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getPlanterId() {
		return planterId;
	}

	public void setPlanterId(Integer planterId) {
		this.planterId = planterId;
	}

	public double getPlanterCost() {
		return planterCost;
	}

	public void setPlanterCost(double planterCost) {
		this.planterCost = planterCost;
	}

	public Integer getPlantId() {
		return plantId;
	}

	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}

	public String getPlantCommonName() {
		return plantCommonName;
	}

	public void setPlantCommonName(String plantCommonName) {
		this.plantCommonName = plantCommonName;
	}

	public Integer getSeedId() {
		return seedId;
	}

	public void setSeedId(Integer seedId) {
		this.seedId = seedId;
	}

	public String getSeedCommonName() {
		return seedCommonName;
	}

	public void setSeedCommonName(String seedCommonName) {
		this.seedCommonName = seedCommonName;
	}
}
