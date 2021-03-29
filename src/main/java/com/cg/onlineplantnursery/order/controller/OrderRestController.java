package com.cg.onlineplantnursery.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.cg.onlineplantnursery.order.dto.AddOrderRequest;
import com.cg.onlineplantnursery.order.dto.DeleteOrderRequest;
import com.cg.onlineplantnursery.order.dto.OrderDetails;
import com.cg.onlineplantnursery.order.dto.UpdateOrderQuantityRequest;
import com.cg.onlineplantnursery.order.dto.UpdateOrderTotalcostRequest;
import com.cg.onlineplantnursery.order.entity.Order;
import com.cg.onlineplantnursery.order.service.IOrderService;
import com.cg.onlineplantnursery.order.util.OrderUtility;

@RequestMapping("/order")
@RestController
public class OrderRestController {
	@Autowired
	private IOrderService service;
	@Autowired
	private OrderUtility util;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/addorder")
	public OrderDetails addPlant(@RequestBody AddOrderRequest requestBody) {
		
		Order order = new Order();
		order.setBookingOrderId(order.getBookingOrderId());
		 order.setOrderDate(order.getOrderDate());
		 order.setQuantity(order.getQuantity());
		 order.setTransactionMode(order.getTransactionMode());
		 order.setTotalCost(order.getTotalCost());
		 Order saved = service.addOrder(order);
		 OrderDetails details = util.toDetails(saved);
		 return details;
	}
	@ResponseStatus(HttpStatus.GONE)
	@DeleteMapping("/deleteorder")
	public String deletePlant(@RequestBody DeleteOrderRequest requestBody) {
		
		Integer orderId = requestBody.getBookingOrderId();
		Order order = service.viewOrder(orderId);
		service.deleteOrder(order);
		return "Order with id "+orderId+" is deleted.";
	}
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping("/updateorderquantity")
	public OrderDetails updateOrderQuantity(@RequestBody UpdateOrderQuantityRequest requestBody) {
		
		Integer orderId = requestBody.getBookingOrderId();
		Order order = service.viewOrder(orderId);
		order.setQuantity(requestBody.getQuantity());
		Order updated = service.updateOrder(order);
		OrderDetails details = util.toDetails(updated);
		return details;
	}
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping("/updateordertotalcost")
	public OrderDetails updateOrderTotalcost(@RequestBody UpdateOrderTotalcostRequest requestBody) {
		
		Integer orderId = requestBody.getBookingOrderId();
		Order order = service.viewOrder(orderId);
		order.setTotalCost(requestBody.getTotalCost());
		Order updated = service.updateOrder(order);
		OrderDetails details = util.toDetails(updated);
		return details;
	}
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("/vieworderbyid/{id}")
	public OrderDetails fetchById(@PathVariable("id") Integer orderId ) {
		
		Order order = service.viewOrder(orderId);
		OrderDetails details = util.toDetails(order);
		return details;
	}
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("/viewallorder")
	public List<OrderDetails> fetchAll() {
		
		List<Order> orderList = service.viewAllOrders();
		List<OrderDetails> desiredList = util.toDetailList(orderList);
		return desiredList;
	}
	
	
}
