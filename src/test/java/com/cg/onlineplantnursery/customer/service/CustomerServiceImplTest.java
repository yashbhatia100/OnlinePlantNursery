package com.cg.onlineplantnursery.customer.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import com.cg.onlineplantnursery.customer.repository.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {
	
	@Mock
	ICustomerRepository repository;
	
	@Spy
	@InjectMocks
	CustomerServiceImpl service;	

}
