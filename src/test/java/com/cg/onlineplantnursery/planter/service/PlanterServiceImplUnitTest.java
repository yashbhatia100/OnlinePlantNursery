package com.cg.onlineplantnursery.planter.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import com.cg.onlineplantnursery.planter.exceptions.InvalidPlanterException;
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
	 * Scenario if the planter is null
	 */
	@Test
	void testValidatePlanter_1() {

		Planter planter = null;
		Executable executable = () -> planterService.validatePlanter(planter);
		assertThrows(InvalidPlanterException.class, executable);
	}

	/*
	 * Scenario planter is added successfully
	 */
	@Test
	void testAddPlanter_1() {

		Planter planter = Mockito.mock(Planter.class);
		Planter saved = Mockito.mock(Planter.class);
		Mockito.when(planterRepository.save(planter)).thenReturn(saved);
		Planter result = planterService.addPlanter(planter);
		assertNotNull(result);
		assertEquals(saved, result);
		verify(planterRepository).save(planter);

	}

	/*
	 * Scenario planter is updated successfully
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
	 * Scenario updating planter which is not in the database
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
	 * Scenario view the planter by id
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
	 * Scenario delete the planter
	 */
	@Test
	void testDeletePlanter_1() {
		int id = 4;
		Planter planter = Mockito.mock(Planter.class);
		when(planter.getPlanterId()).thenReturn(id);
		when(planterRepository.existsById(id)).thenReturn(true);
		Planter result = planterService.deletePlanter(planter);
		assertNull(result);

	}

	/*
	 * Scenario deleting the planter when it does not exist
	 */
	@Test
	void testDeletePlanter_2() {
		int id = 5;
		Planter planter = Mockito.mock(Planter.class);
		when(planter.getPlanterId()).thenReturn(id);
		when(planterRepository.existsById(id)).thenReturn(false);
		Executable executable = () -> planterService.deletePlanter(planter);
		assertThrows(PlanterDeleteException.class, executable);
		verify(planterRepository, never()).delete(planter);

	}

	@Test
	/*
	 * Scenario find by planterShape
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
	 * Scenario find All Planters
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
	 * Scenario find planters by Cost
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
