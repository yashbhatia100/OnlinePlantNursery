package com.cg.onlineplantnursery.order.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.onlineplantnursery.order.dto.OrderDetails;
import com.cg.onlineplantnursery.order.entity.Order;

@Component
public class OrderUtility {
 public OrderDetails toDetails(Order order) {
	 OrderDetails details=new OrderDetails();
	 details.setBookingOrderId(order.getBookingOrderId());
	 details.setOrderDate(order.getOrderDate());
	 details.setQuantity(order.getQuantity());
	 details.setTransactionMode(order.getTransactionMode());
	 details.setTotalCost(order.getTotalCost());
	 return details;
 }
 public List<OrderDetails> toDetailList (List<Order> orderList){
		
		List<OrderDetails> desiredList = new ArrayList<>();
		for(Order order:orderList) {
			desiredList.add(toDetails(order));
		}
		return desiredList;
	}
}
