package com.cg.onlineplantnursery.planter.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.onlineplantnursery.controller.PlanterRestController;
import com.cg.onlineplantnursery.dto.AddPlanterRequest;
import com.cg.onlineplantnursery.dto.DeletePlanterRequest;
import com.cg.onlineplantnursery.dto.PlanterDetails;
import com.cg.onlineplantnursery.dto.UpdatePlanterCapacityRequest;
import com.cg.onlineplantnursery.dto.UpdatePlanterColorRequest;
import com.cg.onlineplantnursery.dto.UpdatePlanterCostRequest;
import com.cg.onlineplantnursery.dto.UpdatePlanterDrainageHolesRequest;
import com.cg.onlineplantnursery.dto.UpdatePlanterHeightRequest;
import com.cg.onlineplantnursery.dto.UpdatePlanterShapeRequest;
import com.cg.onlineplantnursery.dto.UpdatePlanterStockRequest;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.service.IPlanterService;
import com.cg.onlineplantnursery.util.PlanterUtil;

@ExtendWith(MockitoExtension.class)
public class PlanterRestControllerUnitTest {

	@Mock
	private IPlanterService service;

	@Mock
	private PlanterUtil util;

	@Spy
	@InjectMocks
	public PlanterRestController controller;

	/*
	 * Scenario when the Planter is fetched correctly Test case for the fetching the
	 * planter by id in controller
	 * 
	 * 
	 */
	@Test
	void testFetchedPlanter_1() {

		int id = 5;
		Planter planter = mock(Planter.class);
		PlanterDetails details = mock(PlanterDetails.class);
		when(service.viewPlanter(id)).thenReturn(planter);
		when(util.toDetails(planter)).thenReturn(details);
		PlanterDetails result = controller.viewPlanterById(id);
		assertSame(details, result);

	}

	/*
	 * Scenario when the Planter is fetched correctly Test case for the fetching the
	 * planter by shape in controller
	 * 
	 * 
	 */
	@Test
	void testFetchedPlanter_2() {
		String planterShape = "Square";
		List<Planter> planter = mock(List.class);
		List<PlanterDetails> details = mock(List.class);
		when(service.viewPlanter(planterShape)).thenReturn(planter);
		when(util.toDetailsList(planter)).thenReturn(details);
		List<PlanterDetails> result = controller.viewPlannterByplanterShape(planterShape);
		assertSame(details, result);

	}

	/*
	 * Scenario when the Planter is fetched correctly Test case for fetching all the
	 * planters in controller
	 * 
	 * 
	 */
	@Test
	void testFetchedPlanter_3() {

		List<Planter> planter = mock(List.class);
		List<PlanterDetails> details = mock(List.class);
		when(service.viewAllPlanters()).thenReturn(planter);
		when(util.toDetailsList(planter)).thenReturn(details);
		List<PlanterDetails> result = controller.findAllPlannter();
		assertSame(details, result);

	}

	/*
	 * Scenario when the Planter is fetched correctly Test case for fetching the
	 * planters in controller by cost
	 * 
	 * 
	 */
	@Test
	void testFetchedPlanter_4() {
		double minCost = 100d;
		double maxCost = 500d;

		List<Planter> planter = mock(List.class);
		List<PlanterDetails> details = mock(List.class);
		when(service.viewAllPlanters(minCost, maxCost)).thenReturn(planter);
		when(util.toDetailsList(planter)).thenReturn(details);
		List<PlanterDetails> result = controller.findAllPlannterByCost((int) minCost, (int) maxCost);
		assertSame(details, result);

	}

	/*
	 * Scenario when the Planter is deleted correctly Test case for deleting the
	 * planters in controller
	 * 
	 * 
	 */
	@Test
	void testDeletePlanter_1() {
		int id = 10;
		Planter planter = mock(Planter.class);
		DeletePlanterRequest request = mock(DeletePlanterRequest.class);
		when(request.getPlanterId()).thenReturn(id);
		when(service.viewPlanter(id)).thenReturn(planter);
		String result = controller.delete(request);
		verify(service).deletePlanter(planter);

	}

	/*
	 * Scenario when the Planter is added correctly Test case for adding the
	 * planters in controller
	 * 
	 * 
	 */
	@Test
	void testAddPlanter_1() {

		AddPlanterRequest request = mock(AddPlanterRequest.class);
		Planter saved = mock(Planter.class);
		when(service.addPlanter(any(Planter.class))).thenReturn(saved);
		PlanterDetails details = mock(PlanterDetails.class);
		when(util.toDetails(saved)).thenReturn(details);
		PlanterDetails result = controller.addPlanter(request);
		assertSame(details, result);

	}

	/*
	 * Scenario when the PlanterHeight is updated correctly Test case for updating
	 * the planters in controller
	 * 
	 * 
	 */
	@Test
	void testUpdatePlanterHeight() {
		int id = 10;

		UpdatePlanterHeightRequest request = mock(UpdatePlanterHeightRequest.class);
		when(request.getPlanterId()).thenReturn(id);
		Planter planter = mock(Planter.class);
		when(service.viewPlanter(id)).thenReturn(planter);
		Planter saved = mock(Planter.class);
		when(service.updatePlanter(planter)).thenReturn(saved);
		PlanterDetails details = mock(PlanterDetails.class);
		when(util.toDetails(planter)).thenReturn(details);
		PlanterDetails result = controller.updatePlanterHeight(request);
		assertSame(details, result);
		verify(service).updatePlanter(planter);
	}

	/*
	 * Scenario when the PlanterColor is updated correctly Test case for updating
	 * the planters in controller
	 * 
	 * 
	 */
	@Test
	void testUpdatePlanterColor() {
		int id = 10;
		Planter planter = mock(Planter.class);
		UpdatePlanterColorRequest request = mock(UpdatePlanterColorRequest.class);
		when(request.getPlanterId()).thenReturn(id);
		when(service.viewPlanter(id)).thenReturn(planter);

		when(service.updatePlanter(planter)).thenReturn(planter);
		PlanterDetails details = mock(PlanterDetails.class);
		when(util.toDetails(planter)).thenReturn(details);
		PlanterDetails result = controller.updatePlanterColor(request);
		assertNotNull(result);
		assertSame(details, result);
		verify(service).viewPlanter(id);
		verify(service).updatePlanter(planter);

	}

	/*
	 * Scenario when the PlanterCapacity is updated correctly Test case for updating
	 * the planters in controller
	 * 
	 * 
	 */
	@Test
	void testUpdatePlannterCapacity() {
		int id = 10;
		Planter planter = mock(Planter.class);
		UpdatePlanterCapacityRequest request = mock(UpdatePlanterCapacityRequest.class);
		when(request.getPlanterId()).thenReturn(id);
		when(service.viewPlanter(id)).thenReturn(planter);

		when(service.updatePlanter(planter)).thenReturn(planter);
		PlanterDetails details = mock(PlanterDetails.class);
		when(util.toDetails(planter)).thenReturn(details);
		PlanterDetails result = controller.updatePlanterCapacity(request);
		assertNotNull(result);
		assertSame(details, result);
		verify(service).viewPlanter(id);
		verify(service).updatePlanter(planter);

	}

	/*
	 * Scenario when the PlanterDrainageHoles is updated correctly Test case for
	 * updating the planters in controller
	 * 
	 * 
	 */
	@Test
	void testUpdatePlannterDrainageHoles() {
		int id = 10;
		Planter planter = mock(Planter.class);
		UpdatePlanterDrainageHolesRequest request = mock(UpdatePlanterDrainageHolesRequest.class);
		when(request.getPlanterId()).thenReturn(id);
		when(service.viewPlanter(id)).thenReturn(planter);

		when(service.updatePlanter(planter)).thenReturn(planter);
		PlanterDetails details = mock(PlanterDetails.class);
		when(util.toDetails(planter)).thenReturn(details);
		PlanterDetails result = controller.updateDrainageHoles(request);
		assertNotNull(result);
		assertSame(details, result);
		verify(service).viewPlanter(id);
		verify(service).updatePlanter(planter);

	}

	/*
	 * Scenario when the PlanterShape is updated correctly Test case for updating
	 * the planters in controller
	 * 
	 * 
	 */
	@Test
	void testUpdatePlannterShape() {
		int id = 10;
		Planter planter = mock(Planter.class);
		UpdatePlanterShapeRequest request = mock(UpdatePlanterShapeRequest.class);
		when(request.getPlanterId()).thenReturn(id);
		when(service.viewPlanter(id)).thenReturn(planter);

		when(service.updatePlanter(planter)).thenReturn(planter);
		PlanterDetails details = mock(PlanterDetails.class);
		when(util.toDetails(planter)).thenReturn(details);
		PlanterDetails result = controller.updatePlanterShape(request);
		assertNotNull(result);
		assertSame(details, result);
		verify(service).viewPlanter(id);
		verify(service).updatePlanter(planter);

	}

	/*
	 * Scenario when the PlanterCost is updated correctly Test case for updating the
	 * planters in controller
	 * 
	 * 
	 */
	@Test
	void testUpdatePlannterCost() {
		int id = 10;
		Planter planter = mock(Planter.class);
		UpdatePlanterCostRequest request = mock(UpdatePlanterCostRequest.class);
		when(request.getPlanterId()).thenReturn(id);
		when(service.viewPlanter(id)).thenReturn(planter);

		when(service.updatePlanter(planter)).thenReturn(planter);
		PlanterDetails details = mock(PlanterDetails.class);
		when(util.toDetails(planter)).thenReturn(details);
		PlanterDetails result = controller.updatePlanterCost(request);
		assertNotNull(result);
		assertSame(details, result);
		verify(service).viewPlanter(id);
		verify(service).updatePlanter(planter);

	}

	/*
	 * Scenario when the PlanterCost is updated correctly Test case for updating the
	 * planters in controller
	 * 
	 * 
	 */
	@Test
	void testUpdatePlannterStock() {
		int id = 10;
		Planter planter = mock(Planter.class);
		UpdatePlanterStockRequest request = mock(UpdatePlanterStockRequest.class);
		when(request.getPlanterId()).thenReturn(id);
		when(service.viewPlanter(id)).thenReturn(planter);

		when(service.updatePlanter(planter)).thenReturn(planter);
		PlanterDetails details = mock(PlanterDetails.class);
		when(util.toDetails(planter)).thenReturn(details);
		PlanterDetails result = controller.updatePlanterStock(request);
		assertNotNull(result);
		assertSame(details, result);
		verify(service).viewPlanter(id);
		verify(service).updatePlanter(planter);

	}

}
