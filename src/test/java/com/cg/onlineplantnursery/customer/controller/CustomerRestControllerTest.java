package com.cg.onlineplantnursery.customer.controller;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;

import com.cg.onlineplantnursery.customer.controller.*;
import com.cg.onlineplantnursery.customer.entity.*;
import com.cg.onlineplantnursery.customer.dto.*;
import com.cg.onlineplantnursery.customer.util.*;
import com.cg.onlineplantnursery.exceptions.*;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.customer.ui.*;
import com.cg.onlineplantnursery.customer.repository.*;
import com.cg.onlineplantnursery.customer.*;
import com.cg.onlineplantnursery.customer.service.*;
import org.junit.jupiter.api.Test;


@ExtendWith(MockitoExtension.class)
public class CustomerRestControllerTest {
	
	
	@Mock
	private ICustomerService customerService;
	
	@Mock
	private CustomerUtil util;
	
	
	@Spy
	@InjectMocks
	CustomerRestController controller;
	
	@Test
	public void test_AddCustomerRequest() {
		AddCustomerRequest request = mock(AddCustomerRequest.class);
		Customer saved = mock(Customer.class);
		when(customerService.addCustomer(any(Customer.class))).thenReturn(saved);
		CustomerDetails details = mock(CustomerDetails.class);
		when(util.toDetails(any(Customer.class))).thenReturn(details);
		CustomerDetails result= controller.addCustomer(request);
		Assertions.assertNotNull(result);
		Assertions.assertSame(details, result);
		verify(customerService).addCustomer(any(Customer.class));
		verify(util).toDetails(any(Customer.class));
	}
	
	@Test
	public void test_changeCustomerPasswordRequest() {
		Integer id =1;
		ChangeCustomerPasswordRequest request = mock(ChangeCustomerPasswordRequest.class);
		Customer customer = mock(Customer.class);
		when(request.getCustomerId()).thenReturn(id);
		when(request.getPassword()).thenReturn("");
	    when(customerService.viewCustomer(id)).thenReturn(customer);
	    when(customerService.updateCustomer(customer)).thenReturn(customer);
	    CustomerDetails details = mock(CustomerDetails.class);
	    when(util.toDetails(customer)).thenReturn(details);
	    CustomerDetails result = controller.changePassword(request);
	    Assertions.assertNotNull(result);
		Assertions.assertSame(details, result);
		verify(customerService).viewCustomer(id);
		verify(customerService).updateCustomer(customer);
		verify(util).toDetails(customer);
		
	}
	@Test
	public void test_changeCustomerAddressRequest() {
		Integer id =5;
		ChangeCustomerAddressRequest request = mock(ChangeCustomerAddressRequest.class);
		Customer customer = mock(Customer.class);
		when(request.getCustomerId()).thenReturn(id);
	Address address = mock(Address.class);
		when(customer.getAddress()).thenReturn(address);
		/*when(request.getHouseNo()).thenReturn("119");
		when(request.getColony()).thenReturn("Shastri Nagar");
		when(request.getCity()).thenReturn("Chennai");
		when(request.getState()).thenReturn("TamilNadu");
		when(request.getPincode()).thenReturn(603202);*/
		when(customerService.viewCustomer(id)).thenReturn(customer);
		//when(customerService.updateCustomer(customer)).thenReturn(customer);
		CustomerDetails details = mock(CustomerDetails.class);
		when(util.toDetails(customer)).thenReturn(details);
		CustomerDetails result = controller.changeAddress(request);
		Assertions.assertNotNull(result);
		Assertions.assertSame(details, result);
		verify(customerService).viewCustomer(id);
		verify(customerService).updateCustomer(customer);
		verify(util).toDetails(customer);
			
		
	}
	
	@Test
	public void test_allCustomerDetails() {
		
		List<Customer> customerList = mock(List.class);
		when(customerService.viewAllCustomers()).thenReturn(customerList);
		List<CustomerDetails> desiredList = mock(List.class);
		when(util.toDetailList(customerList)).thenReturn(desiredList);
		List<CustomerDetails> resultList = controller.allCustomerDetails();
		Assertions.assertNotNull(resultList);
		Assertions.assertSame(desiredList, resultList);
		verify(customerService).viewAllCustomers();
		verify(util).toDetailList(customerList);
	}
	
	
}
