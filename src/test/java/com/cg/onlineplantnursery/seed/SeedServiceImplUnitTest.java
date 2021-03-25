package com.cg.onlineplantnursery.seed;

import java.util.List;

import com.cg.onlineplantnursery.seed.repository.ISeedRepository;
import com.cg.onlineplantnursery.seed.service.SeedServiceImpl;
import com.cg.onlineplantnursery.seed.entity.Seed;
import com.cg.onlineplantnursery.exceptions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SeedServiceImplUnitTest {

	@Mock
	ISeedRepository repository;

	@Spy
	@InjectMocks
	SeedServiceImpl service;

	/*
	 * success scenario: seed added
	 */
	@Test
	public void testAddSeed_1() {
		Seed seed = Mockito.mock(Seed.class);
		Seed saved = Mockito.mock(Seed.class);
		Mockito.when(repository.save(seed)).thenReturn(saved);
		Seed result = service.addSeed(seed);
		Assertions.assertNotNull(result);
		Assertions.assertEquals(saved, result);
		Mockito.verify(repository).save(seed);
	}

	/*
	 * scenario: seed is null
	 */
	@Test
	public void testAddSeed_2() {
		Seed seed = null;
		Executable executable = () -> service.addSeed(seed);
		Assertions.assertThrows(SeedAddException.class, executable);
		Mockito.verify(repository, Mockito.never()).save(seed);

	}

	/*
	 * success scenario: seed is updated
	 */
	@Test
	public void testUpdateSeed_1() {
		Integer id = 1;
		Seed seed = Mockito.mock(Seed.class);
		Mockito.when(seed.getSeedId()).thenReturn(id);
		Mockito.when(repository.existsById(id)).thenReturn(true);
		Mockito.when(repository.save(seed)).thenReturn(seed);
		Seed result = service.updateSeed(seed);
		Assertions.assertNotNull(result);
		Assertions.assertEquals(seed, result);
		Mockito.verify(repository).save(seed);
	}

	/*
	 * scenario: id does not exist
	 */
	@Test
	public void testUpdateSeed_2() {
		Integer id = 2;
		Seed seed = Mockito.mock(Seed.class);
		Mockito.when(seed.getSeedId()).thenReturn(id);
		Mockito.when(repository.existsById(id)).thenReturn(false);
		Executable executable = () -> service.updateSeed(seed);
		Assertions.assertThrows(SeedUpdateException.class, executable);
		Mockito.verify(repository, Mockito.never()).save(seed);
	}

	/*
	 * success scenario: when all seeds are viewed
	 */
	@Test
	public void testViewAllSeeds_1() {
		List<Seed> seedList = Mockito.mock(List.class);
		Mockito.when(repository.viewAllSeeds()).thenReturn(seedList);
		Mockito.when(seedList.isEmpty()).thenReturn(false);
		List<Seed> result = service.viewAllSeeds();
		Assertions.assertNotNull(result);
		Assertions.assertEquals(seedList, result);
	}

	/*
	 * scenario: when seedList is empty
	 */
	@Test
	public void testViewAllSeeds_2() {
		List<Seed> seedList = Mockito.mock(List.class);
		Mockito.when(repository.viewAllSeeds()).thenReturn(seedList);
		Mockito.when(seedList.isEmpty()).thenReturn(true);
		Executable executable = () -> service.viewAllSeeds();
		Assertions.assertThrows(SeedNotFoundException.class, executable);
	}

	/*
	 * success scenario: when all seeds of typeOfSeed viewed
	 */
	@Test
	public void testViewAllTypeSeeds_1() {
		String typeOfSeed = "Pineapple";
		List<Seed> seedList = Mockito.mock(List.class);
		Mockito.when(repository.viewAllSeeds(typeOfSeed)).thenReturn(seedList);
		Mockito.when(seedList.isEmpty()).thenReturn(false);
		List<Seed> result = service.viewAllSeeds(typeOfSeed);
		Assertions.assertNotNull(result);
		Assertions.assertEquals(seedList, result);
	}

	/*
	 * scenario: when seedList is empty
	 */
	@Test
	public void testViewAllTypeSeeds_2() {
		String typeOfSeed = "apple";
		List<Seed> seedList = Mockito.mock(List.class);
		Mockito.when(repository.viewAllSeeds(typeOfSeed)).thenReturn(seedList);
		Mockito.when(seedList.isEmpty()).thenReturn(true);
		Executable executable = () -> service.viewAllSeeds(typeOfSeed);
		Assertions.assertThrows(SeedTypeNotFoundException.class, executable);
	}
}