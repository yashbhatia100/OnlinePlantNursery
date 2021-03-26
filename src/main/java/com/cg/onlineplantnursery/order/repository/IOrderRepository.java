package com.cg.onlineplantnursery.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineplantnursery.order.entity.Order;

public interface IOrderRepository extends JpaRepository<Order, Integer>  {
	Order addOrder(Order order);
	Order updateOrder(Order order);
	Order deleteOrder(Order order);
	Order viewOrder(int  orderId);
	List<Order> viewAllOrders();
	

}
