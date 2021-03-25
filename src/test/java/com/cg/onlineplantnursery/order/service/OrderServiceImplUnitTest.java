package com.cg.onlineplantnursery.order.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cg.onlineplantnursery.order.service.IOrderServiceImpl;
import com.cg.onlineplantnursery.exceptions.OrderUpdateException;
import com.cg.onlineplantnursery.order.entity.Order;
import com.cg.onlineplantnursery.order.repository.IOrderRepository;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplUnitTest {
	
	@Mock
	IOrderRepository repository;
	

	@Spy
	@InjectMocks
	IOrderServiceImpl service;
	
	/*
	 * *Scenario when order object is updated successfully
	 */
	@Test
	public void testAddOrder() {
		Order order=mock(Order.class);
		Order saved=mock(Order.class);
		Mockito.when(repository.save(order)).thenReturn(saved);
		Order result=service.addOrder(order);
		Assertions.assertNotNull(result);
		Assertions.assertSame(saved, result);
		verify(repository).save(order);
	  
		
	}
	
	/*
	 * Test method for updateorder() when the object is updated successfully
	 */
	@Test
	public void testUpdateOrder_1() {
	Integer id=97;
	Order order=mock(Order.class);
	when(order.getBookingOrderId()).thenReturn(id);
	when(repository.save(order)).thenReturn(order);
	when(repository.existsById(id)).thenReturn(true);
	Order result=service.updateOrder(order);
	Assertions.assertNotNull(result);
	Assertions.assertSame(order, result);
	verify(repository).save(order);	
	}
	/*
	 * Test method for updateorder() when the object to update doesn't exist
		 */
	@Test
	public void testUpdateOrder_2() {
	Integer id=97;
	Order order=mock(Order.class);
	when(order.getBookingOrderId()).thenReturn(id);
    Executable executable=()->service.updateOrder(order);
    Assertions.assertThrows(OrderUpdateException.class, executable);
	}

	

}
