package com.cg.onlineplantnursery.order.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.onlineplantnursery.exceptions.OrderUpdateException;
import com.cg.onlineplantnursery.order.entity.Order;
import com.cg.onlineplantnursery.order.repository.IOrderRepository;

@Service
public class IOrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepository repository;
	
	@Transactional
	@Override
	public Order addOrder(Order order) {
		
    Order saved= repository.save(order);
	return  saved;

	
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
	public Order deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order viewOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> viewAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
