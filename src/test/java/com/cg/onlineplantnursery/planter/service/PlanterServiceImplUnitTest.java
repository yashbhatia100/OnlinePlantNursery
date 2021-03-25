package com.cg.onlineplantnursery.planter.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.exceptions.InvalidPlanterDataException;
import com.cg.onlineplantnursery.planter.exceptions.InvalidPlanterException;
import com.cg.onlineplantnursery.planter.exceptions.InvalidPlanterIdException;
import com.cg.onlineplantnursery.planter.exceptions.PlanterDeleteException;
import com.cg.onlineplantnursery.planter.exceptions.PlanterUpdateException;
import com.cg.onlineplantnursery.planter.repository.IPlanterRepository;

@ExtendWith(MockitoExtension.class)
class PlanterServiceImplUnitTest {

	@Mock
	IPlanterRepository planterRepository;

	@Spy
	@InjectMocks
	PlanterServiceImpl planterService;

	/*
	 * Scenario if the planter is null Test case for addPlanter
	 */
	@Test
	void testAddPlanter_1() {

		Planter planter = null;
		Executable executable = () -> planterService.validatePlanter(planter);
		assertThrows(InvalidPlanterException.class, executable);
		verify(planterRepository, never()).save(planter);
	}

	/*
	 * Scenario planter is added successfully Test case for add planter
	 */

	@Test
	void testAddPlanter_2() {
		
		Planter planter = Mockito.mock(Planter.class);
		Planter saved = Mockito.mock(Planter.class);
		float planterHeight=10.0f;
		int planterCapacity=2;
		String PlanterColor="Red";
		int planterCost=10;
		int planterStock=14;
		int drainageHoles=3;
		String planterShape="Rectangle";
		when(planter.getPlanterHeight()).thenReturn(planterHeight);
		when(planter.getPlanterCapacity()).thenReturn(planterCapacity);
		when(planter.getPlanterColor()).thenReturn(PlanterColor);
		when(planter.getDrainageHoles()).thenReturn(drainageHoles);
		when(planter.getPlanterStock()).thenReturn(planterStock);
		when(planter.getPlanterCost()).thenReturn(planterCost);
		when(planter.getPlanterShape()).thenReturn(planterShape);
		
		doNothing().when(planterService).validatePlanter(planter);
		doNothing().when(planterService).validatePlanterHeight(planterHeight);
		doNothing().when(planterService).validatePlanterCapacity(planterCapacity);
		doNothing().when(planterService).validatePlanterColor(PlanterColor);
		doNothing().when(planterService).validateDrainageHoles(drainageHoles);
		doNothing().when(planterService).validatePlanterCost(planterCost);
		doNothing().when(planterService).validatePlanterStock(planterStock);
		doNothing().when(planterService).validatePlanterShape(planterShape);
		
		when(planterRepository.save(planter)).thenReturn(saved);
		Planter result = planterService.addPlanter(planter);
		assertNotNull(result);
		assertEquals(saved, result);
		verify(planterRepository).save(planter);
		verify(planterService).validatePlanterHeight(planter.getPlanterHeight());
		verify(planterService).validatePlanterCapacity(planter.getPlanterCapacity());
		verify(planterService).validatePlanterColor(planter.getPlanterColor());
		verify(planterService).validateDrainageHoles(planter.getDrainageHoles());
		verify(planterService).validatePlanterShape(planter.getPlanterShape());
		verify(planterService).validatePlanterCost(planter.getPlanterCost());
		verify(planterService).validatePlanterStock(planter.getPlanterStock());

	}

	/*
	 * Scenario planter when planter height is null Test case for add planter
	 */

	@Test
	void testAddPlanter_3() {
		float planterHeight = 0.0f;
		Planter planter = Mockito.mock(Planter.class);
		doThrow(InvalidPlanterDataException.class).when(planterService).validatePlanterHeight(planterHeight);
		Executable executable = () -> planterService.addPlanter(planter);
		assertThrows(InvalidPlanterDataException.class, executable);
		verify(planterRepository, never()).save(planter);

	}

	/*
	 * Scenario planter when planter capacity is null Test case for add planter
	 */

	@Test
	void testAddPlanter_4() {
		int planterCapacity = 0;
		Planter planter = Mockito.mock(Planter.class);
		doThrow(InvalidPlanterDataException.class).when(planterService).validatePlanterCapacity(planterCapacity);
		Executable executable = () -> planterService.addPlanter(planter);
		assertThrows(InvalidPlanterDataException.class, executable);
		verify(planterRepository, never()).save(planter);

	}

	/*
	 * Scenario planter when drainage holes is null Test case for add planter
	 */

	@Test
	void testAddPlanter_5() {
		int drainageHoles = 0;
		Planter planter = Mockito.mock(Planter.class);
		doThrow(InvalidPlanterDataException.class).when(planterService).validateDrainageHoles(drainageHoles);
		;
		Executable executable = () -> planterService.addPlanter(planter);
		assertThrows(InvalidPlanterDataException.class, executable);
		verify(planterRepository, never()).save(planter);

	}
	

	/*
	 * Scenario planter when planter cost is null Test case for add planter
	 */

	@Test
	void testAddPlanter_6() {
		int planterCost = 0;
		Planter planter = Mockito.mock(Planter.class);
		doThrow(InvalidPlanterDataException.class).when(planterService).validatePlanterCost(planterCost);
		Executable executable = () -> planterService.addPlanter(planter);
		assertThrows(InvalidPlanterDataException.class, executable);
		verify(planterRepository, never()).save(planter);

	}
	
	/*
	 * Scenario planter when planter stock is null Test case for add planter
	 */

	@Test
	void testAddPlanter_7() {
		int planterStock = 0;
		Planter planter = Mockito.mock(Planter.class);
		doThrow(InvalidPlanterDataException.class).when(planterService).validatePlanterStock(planterStock);
		Executable executable = () -> planterService.addPlanter(planter);
		assertThrows(InvalidPlanterDataException.class, executable);
		verify(planterRepository, never()).save(planter);

	}

	/*
	 * Scenario planter when drainage holes is null Test case for add planter
	 */

	@Test
	void testAddPlanter_8() {
		String planterColor = null;
		Planter planter = Mockito.mock(Planter.class);
		doThrow(InvalidPlanterDataException.class).when(planterService).validatePlanterColor(planterColor);
		Executable executable = () -> planterService.addPlanter(planter);
		assertThrows(InvalidPlanterDataException.class, executable);
		verify(planterRepository, never()).save(planter);

	}

	/*
	 * Scenario planter when planter shape is null Test case for add planter
	 */

	@Test
	void testAddPlanter_9() {
		String planterShape = null;
		Planter planter = Mockito.mock(Planter.class);
		doThrow(InvalidPlanterDataException.class).when(planterService).validatePlanterShape(planterShape);
		Executable executable = () -> planterService.addPlanter(planter);
		assertThrows(InvalidPlanterDataException.class, executable);
		verify(planterRepository, never()).save(planter);

	}

	


	/*
	 * Scenario planter is updated successfully Test case for update planter
	 */
	@Test
	void testUpdatePlanter_1() {
		int id = 10;
		Planter planter = mock(Planter.class);
		when(planter.getPlanterId()).thenReturn(id);
		when(planterRepository.save(planter)).thenReturn(planter);
		when(planterRepository.existsById(id)).thenReturn(true);
		Planter result = planterService.updatePlanter(planter);
		assertNotNull(result);
		assertSame(planter, result);
		verify(planterRepository).save(planter);

	}
	/*
	 * Scenario updating planter which is not in the database Test case for update
	 * planter
	 */

	@Test
	void testUpdatePlanter_2() {
		int id = 10;
		Planter planter = mock(Planter.class);
		when(planter.getPlanterId()).thenReturn(id);
		when(planterRepository.existsById(id)).thenReturn(false);
		Executable executable = () -> planterService.updatePlanter(planter);
		assertThrows(PlanterUpdateException.class, executable);
		verify(planterRepository, never()).save(planter);

	}

	/*
	 * Scenario view the planter by id test case for view planter
	 */
	@Test
	void testViewPlanter_1() {
		int id = 5;
		Planter planter = Mockito.mock(Planter.class);
		Optional<Planter> optional = Optional.of(planter);
		when(planterRepository.findById(5)).thenReturn(optional);
		Planter result = planterService.viewPlanter(id);
		assertNotNull(result);
		assertEquals(planter, result);
	}

	/*
	 * Scenario delete the planter test case for delete planter
	 */
	@Test
	void testDeletePlanter_1() {
		int id=4;
		Planter planter = Mockito.mock(Planter.class);
		when(planterRepository.existsById(id)).thenReturn(true);
		Planter result = planterService.deletePlanter(planter);
		assertSame(planter,result);
		verify(planterRepository).delete(planter);

	}

	/*
	 * Scenario deleting the planter when it does not exist test case for delete
	 * planter
	 */
	@Test
	void testDeletePlanter_2() {
		int id = 5;
		Planter planter = Mockito.mock(Planter.class);
		when(planterRepository.existsById(id)).thenReturn(false);
		Executable executable = () -> planterService.deletePlanter(planter);
		assertThrows(PlanterDeleteException.class, executable);
		verify(planterRepository, never()).delete(planter);

	}

	@Test
	/*
	 * Scenario find by planterShape test case for planterShape
	 */
	void testViewPlanterbyShape_1() {

		String planterShape = "Cylinderical";
		List<Planter> list = Mockito.mock(List.class);
		when(planterRepository.viewPlanter(planterShape)).thenReturn(list);
		List<Planter> result = planterService.viewPlanter(planterShape);
		assertNotNull(result);
		assertEquals(list, result);

	}

	@Test
	/*
	 * Scenario find All Planters test case for viewing all planter
	 */
	void testViewAllPlanters_1() {
		List<Planter> list = Mockito.mock(List.class);
		when(planterRepository.viewAllPlanters()).thenReturn(list);
		List<Planter> result = planterService.viewAllPlanters();
		assertNotNull(result);
		assertEquals(list, result);

	}

	@Test
	/*
	 * Scenario find planters by Cost test case for view all planters by cost
	 */
	void testViewAllPlanters_2() {
		double minCost = 100d;
		double maxCost = 500d;
		List<Planter> list = Mockito.mock(List.class);
		when(planterRepository.viewAllPlanters(minCost, maxCost)).thenReturn(list);
		List<Planter> result = planterService.viewAllPlanters(minCost, maxCost);
		assertNotNull(result);
		assertEquals(list, result);

	}

}
