package com.cg.onlineplantnursery.order.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.onlineplantnursery.order.dto.AddOrderRequest;
import com.cg.onlineplantnursery.order.dto.DeleteOrderRequest;
import com.cg.onlineplantnursery.order.dto.OrderDetails;
import com.cg.onlineplantnursery.order.dto.UpdateOrderQuantityRequest;
import com.cg.onlineplantnursery.order.dto.UpdateOrderTotalcostRequest;
import com.cg.onlineplantnursery.order.entity.Order;
import com.cg.onlineplantnursery.order.service.IOrderService;
import com.cg.onlineplantnursery.order.util.OrderUtility;



@ExtendWith(MockitoExtension.class)
class PlantRestControllerUnitTest {

	@Mock
	IOrderService service;
	
	@Mock
	OrderUtility util;
	
	@Spy
	@InjectMocks
	OrderRestController controller;
	
	/*
	 * To Test: addOrder()
	 * Scenario: Order object is added successfully
	 * Input: mock AddOrderRequest object and order object.
	 * Expectation: service.addOrder() and util.toDetails() are called. 
	 */
	@Test
	void test_addOrder() {
		AddOrderRequest request = mock(AddOrderRequest.class);
		Order saved = mock(Order.class);
		when(service.addOrder(any(Order.class))).thenReturn(saved);
		OrderDetails details = mock(OrderDetails.class);
		when(util.toDetails(saved)).thenReturn(details);
		OrderDetails result = controller.addPlanterOrder(request);
		Assertions.assertNotNull(result);
		Assertions.assertSame(details, result);	
		verify(service).addOrder(any(Order.class));
		verify(util).toDetails(saved);
	}
	
	/*
	 * To Test: deleteOrder()
	 * Scenario: Order object is deleted successfully
	 * Input: mock DeleteOrderRequest object and Order object.
	 * Expectation: service.viewOrder() and service.deleteOrder() are called. 
	 */
	@Test
	void test_deletePlant() {
		Integer id = 1;
		DeleteOrderRequest request = mock(DeleteOrderRequest.class);
		Order order = mock(Order.class);
		when(request.getBookingOrderId()).thenReturn(id);
		when(service.viewOrder(id)).thenReturn(order);
		controller.deletePlant(request);
		verify(service).viewOrder(id);
		verify(service).deleteOrder(order);
	}
	
	/*
	 * To Test: updateOrderQuantity()
	 * Scenario: Order object is updated successfully
	 * Input: mock UpdateOrderQuantityRequest object and Order object.
	 * Expectation: service.viewOrder(), service.updateOrder() and util.toDetails() are called. 
	 */
	@Test
	void test_updateOrderQuantity() {
		Integer id = 1;
		UpdateOrderQuantityRequest request = mock(UpdateOrderQuantityRequest.class);
		Order order = mock(Order.class);
		when(request.getBookingOrderId()).thenReturn(id);
		when(request.getQuantity()).thenReturn(70);
		when(service.viewOrder(id)).thenReturn(order);
		when(service.updateOrder(order)).thenReturn(order);
		OrderDetails details = mock(OrderDetails.class);
		when(util.toDetails(order)).thenReturn(details);
		OrderDetails result = controller.updateOrderQuantity(request);
		Assertions.assertNotNull(result);
		Assertions.assertSame(details, result);
		verify(service).viewOrder(id);
		verify(service).updateOrder(order);
		verify(util).toDetails(order);
	}
	
	/*
	 * To Test: updateOrderTotalcost()
	 * Scenario: Order object is updated successfully
	 * Input: mock UpdateOrderTotalCostRequest object and Order object.
	 * Expectation: service.viewOrder(), service.updateOrder() and util.toDetails() are called. 
	 */
	@Test
	void test_updateOrderTotalcost() {
		Integer id = 1;
		UpdateOrderTotalcostRequest request = mock(UpdateOrderTotalcostRequest.class);
		Order order = mock(Order.class);
		when(request.getBookingOrderId()).thenReturn(id);
		when(request.getTotalCost()).thenReturn(70.0);
		when(service.viewOrder(id)).thenReturn(order);
		when(service.updateOrder(order)).thenReturn(order);
		OrderDetails details = mock(OrderDetails.class);
		when(util.toDetails(order)).thenReturn(details);
		OrderDetails result = controller.updateOrderTotalcost(request);
		Assertions.assertNotNull(result);
		Assertions.assertSame(details, result);
		verify(service).viewOrder(id);
		verify(service).updateOrder(order);
		verify(util).toDetails(order);
	}

	

}