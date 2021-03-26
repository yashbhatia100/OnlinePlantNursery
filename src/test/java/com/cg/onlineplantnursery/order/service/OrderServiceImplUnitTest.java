package com.cg.onlineplantnursery.order.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

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

import antlr.collections.List;

import com.cg.onlineplantnursery.exceptions.OrderIdNotFoundException;
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
	 * * Scenario if the order is null Test case for addOrder
	 */
	@Test
	public void testAddOrder() {
		Order order=null;
		 Executable executable=()->service.validateOrder(order);
		    Assertions.assertThrows(OrderUpdateException.class, executable);
		    verify(repository,never()).save(order);
		
		
		
	}
	/*
	 * Scenario Order is updated successfully Test case for update oder
	 */
	
	@Test
	public void testUpdateOrder_1() {
	Integer id=97;
	Order order=mock(Order.class);
	when(order.getBookingOrderId()).thenReturn(id);
	when(repository.save(order)).thenReturn(order);
	when(repository.existsById(id)).thenReturn(true);
	
	Order result=service.updateOrder(order);
	assertNotNull(result);
	assertSame(order, result);
	verify(repository).save(order);	
	}
	/*
	 * Scenario updating order which is not in the database Test case for update
		 */
	@Test
	public void testUpdateOrder_2() {
	Integer id=97;
	Order order=mock(Order.class);
	when(order.getBookingOrderId()).thenReturn(id);
	when(repository.existsById(id)).thenReturn(false);
    Executable executable=()->service.updateOrder(order);
    assertThrows(OrderUpdateException.class, executable);
    verify(repository,never()).save(order);
	}
	
	/*
	 * Scenario view the Order by id test case for view Order
	 */
	@Test
	void testViewOrder_1() {
		int id = 5;
		Order order=Mockito.mock(Order.class);
		Optional<Order> optional = Optional.of(order);
		when(repository.findById(5)).thenReturn(optional);
		Order result = service.viewOrder(id);
		assertNotNull(result);
		assertEquals(order, result);
	}
	/*
	 * Scenario delete the Order test case for delete Order
	 */
	@Test
	void testDeleteOrder_1() {
		int id=10;
		Order order = Mockito.mock(Order.class);
		doNothing().when(service).validateBookingId(id);
		Order result = service.deleteOrder(order);
		assertSame(order,result);
		verify(repository).delete(order);

	}
	

	/*
	 * Scenario deleting the Order when it does not exist test case for delete
	 * Order
	 */
	@Test
	void testDeleteOrder_2() {
		int id=10;
		Order order = Mockito.mock(Order.class);
		doThrow(OrderIdNotFoundException.class).when(service).validateBookingId(id);
		
		Executable executable = () -> service.deleteOrder(order);
		assertThrows(OrderIdNotFoundException.class, executable);
		verify(repository, never()).delete(order);

	}
	
	
	


	

}
