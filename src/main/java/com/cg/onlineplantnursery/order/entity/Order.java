package com.cg.onlineplantnursery.order.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.cg.onlineplantnursery.customer.entity.Customer;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.seed.entity.Seed;

@Entity
@Table(name="order_details")
public class Order {
	
	@GeneratedValue
	@Id
	private Integer bookingOrderId;
	private LocalDate orderDate;
	private String transactionMode;
	private int quantity;
	private double totalCost;

	@ManyToOne
	private Planter planter;

	@ManyToOne
	private Customer customer;

	public Planter getPlanter() {
		return planter;
	}

	public void setPlanter(Planter planter) {
		this.planter = planter;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order() {
		this.orderDate =  LocalDate.now();
	}
	public Integer getBookingOrderId() {
		return bookingOrderId;
	}
	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
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



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Order order = (Order) o;
		return Objects.equals(bookingOrderId, order.bookingOrderId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingOrderId);
	}
}
