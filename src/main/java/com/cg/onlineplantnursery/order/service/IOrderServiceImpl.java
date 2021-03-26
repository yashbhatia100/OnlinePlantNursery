package com.cg.onlineplantnursery.order.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.exceptions.OrderIdNotFoundException;
import com.cg.onlineplantnursery.exceptions.OrderUpdateException;
import com.cg.onlineplantnursery.order.entity.Order;
import com.cg.onlineplantnursery.order.repository.IOrderRepository;

@Service
public class IOrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepository repository;
	
	//@Transactional
	@Override
	public Order addOrder(Order order) {
  
    validateOrder(order);
    validateBookingId(order.getBookingOrderId());
    validateTransactionMode(order.getTransactionMode());
    validateQuantity(order.getQuantity());
	return  repository.save(order);

	
	}

	@Override
	public Order updateOrder(Order order) {
		Integer id=order.getBookingOrderId();
		boolean exists= repository.existsById(id);
		if(!exists) {
			throw new OrderUpdateException("Order id is not found for "+id);
		}
		Order saved=repository.save(order);
		return saved;
		
	
	}

	@Override
	public Order deleteOrder(Order order) {
		validateOrder(order);
		boolean exists= repository.existsById(order.getBookingOrderId());
		if(!exists) {
			throw new OrderUpdateException("Order id is not found for "+order.getBookingOrderId());
		}
		repository.delete(order);
		return order;
	}

	@Override
	public Order viewOrder(int orderId) {
		validateBookingId(orderId);
		Optional<Order> orderList=repository.findById(orderId);
		if (!orderList.isPresent()) {
			throw new OrderIdNotFoundException("Order is not found for this Id");
			
		}
		return orderList.get();
	}

	@Override
	public List<Order> viewAllOrders() {
		
		List<Order> orderList = repository.viewAllOrders();
		if (orderList.isEmpty()) {
			return null;
		}

		return orderList;
	}
	
	public void validateOrder(Order order) {
		if (order== null) {
			throw new OrderIdNotFoundException("Order cannot be null");
		}

	}
	public void validateBookingId(int bookingid) {
		if (bookingid<0) {
			throw new OrderIdNotFoundException("Invalid OrderBookingID");
		}
		
	}
	public void validateTransactionMode(String TransactionMode) {
		if (TransactionMode==null) {
			throw new OrderIdNotFoundException("TransactionMode can't be null");
		}
	}
	public void validateQuantity(int Quantity) {
		if (Quantity<0) {
			throw new OrderIdNotFoundException("Invalid Quantity");
		}
		
	}

}
