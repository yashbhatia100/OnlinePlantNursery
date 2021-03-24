package com.cg.onlineplantnursery.planter.service;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.repository.IPlanterRepository;

@ExtendWith(MockitoExtension.class)
class PlanterServiceImplUnitTest {

	@Mock
	IPlanterRepository repository;

	@Spy
	@InjectMocks
	PlanterServiceImpl service;

	@Test
	public void testAddPlanter_1() {
		float planterHeight = 10.0f;
		int planterCapacity = 5;
		int drainageHoles = 2;
		String planterShape = "Cylinderical";
		String planterColor="Red";
		int planterStock = 10;
		int planterCost = 100;
		
		Planter planter=new Planter(planterHeight,planterCapacity,drainageHoles,planterColor,planterShape,planterStock,planterCost);
		Planter saved=Mockito.mock(Planter.class);
	    Mockito.when(repository.save(planter)).thenReturn(saved);
	    Planter result=service.addPlanter(planter);
	    Assertions.assertNotNull(result);
	    Assertions.assertEquals(saved,result);
	  
		
	}
	
	@Test
	public void testUpdatePlanter_1() {
	
		
	}
	
	
	
	@Test
	public void testViewPlanter_1() {
		int id =5;
		Planter planter=Mockito.mock(Planter.class);
		Optional<Planter>optional=Optional.of(planter);
		when(repository.findById(5)).thenReturn(optional);
		Planter result=service.viewPlanter(id);
		Assertions.assertEquals(planter, result);
	}
	
	
	

}
