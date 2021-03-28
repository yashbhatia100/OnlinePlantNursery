
package com.cg.onlineplantnursery.order.ui;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlineplantnursery.order.entity.Order;
import com.cg.onlineplantnursery.order.service.IOrderService;

import java.util.List;


@Component
public class OrderUi {
	@Autowired
	private IOrderService service;
	public void start() {
		Order order1=new Order();
		Order order2=new Order();
		Order order3=new Order();
		
		order1.setBookingOrderId(1);
		order1.setOrderDate(LocalDate.of(2021, 03, 27));
		order1.setQuantity(10);
		order1.setTransactionMode("online");
		order1.setTotalCost(1000);
		
		order2.setBookingOrderId(2);
		order2.setOrderDate(LocalDate.of(2021, 03, 26));
		order2.setQuantity(16);
		order2.setTransactionMode("cash");
		order2.setTotalCost(123000);
		
		order3.setBookingOrderId(3);
		order3.setOrderDate(LocalDate.of(2021, 03, 25));
		order3.setQuantity(17);
		order3.setTransactionMode("online");
		order3.setTotalCost(15000);
		
		service.addOrder(order1);
		service.addOrder(order2);
		service.addOrder(order3);
		
		System.out.println("\n********************* Saved Order in database *********************\n");
		display(order1);
		display(order2);
		display(order3);
		
		order1.setQuantity(19);
		order2.setTransactionMode("bitcoin");
		order3.setTotalCost(40000);
		
		service.updateOrder(order1);
		service.updateOrder(order2);
		service.updateOrder(order3);
		
		Order fetchOrder1=service.viewOrder(order1.getBookingOrderId());
		Order fetchOrder2=service.viewOrder(order2.getBookingOrderId());
		Order fetchOrder3=service.viewOrder(order3.getBookingOrderId());
		
		System.out.println("\n********************* Updated Order in database *********************\n");
		display(fetchOrder1);
		display(fetchOrder2);
		display(fetchOrder3);
		
		service.deleteOrder(fetchOrder2);
        System.out.println("\n********************* Deleted a Order from database *********************\n");
		
		List<Order> allOrders = service.viewAllOrders();
		
		for(Order order:allOrders) {
			display(order);
		}	
	}
	
	public void display(Order order) {
		
		System.out.println("orderId: "+order.getBookingOrderId()+"\n order Quantity: "+order.getQuantity()
							+"\nTotal cost: "+order.getTotalCost()+"\n Transaction mode: "+order.getTransactionMode()
							+"\norder Time: "+order.getOrderDate());
		
		System.out.println("------------------------------------------------------");
	}
}
