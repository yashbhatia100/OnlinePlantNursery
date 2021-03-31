package com.cg.onlineplantnursery.seed.controller;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Assertions;
import org.mockito.junit.jupiter.MockitoExtension;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.cg.onlineplantnursery.controller.SeedRestController;
import com.cg.onlineplantnursery.dto.ChangeCommonNameRequest;
import com.cg.onlineplantnursery.dto.ChangeSeedsCostRequest;
import com.cg.onlineplantnursery.dto.ChangeSeedsStockRequest;
import com.cg.onlineplantnursery.dto.CreateSeedRequest;
import com.cg.onlineplantnursery.dto.DeleteSeedRequest;
import com.cg.onlineplantnursery.dto.SeedDetails;
import com.cg.onlineplantnursery.seed.entity.Seed;
import com.cg.onlineplantnursery.seed.service.ISeedService;
import com.cg.onlineplantnursery.util.SeedUtil;

@ExtendWith(MockitoExtension.class)
public class SeedRestControllerUnitTest {
	@Mock
	ISeedService service;

	@Mock
	SeedUtil util;

	@Spy
	@InjectMocks
	SeedRestController controller;

	@Test
	public void testAddSeed() {
		Seed saved = Mockito.mock(Seed.class);
		CreateSeedRequest request = Mockito.mock(CreateSeedRequest.class);
		Mockito.when(service.addSeed(Mockito.any(Seed.class))).thenReturn(saved);
		SeedDetails details = Mockito.mock(SeedDetails.class);
		Mockito.when(util.toDetails(saved)).thenReturn(details);
		SeedDetails result = controller.addSeed(request);
		Assertions.assertSame(details, result);

	}

	@Test
	public void testUpdateSeedCommonName() {
		int id = 1;
		Seed seed = Mockito.mock(Seed.class);
		ChangeCommonNameRequest request = Mockito.mock(ChangeCommonNameRequest.class);
		Mockito.when(request.getSeedId()).thenReturn(id);
		Mockito.when(request.getCommonName()).thenReturn("Mango Seed");
		Mockito.when(service.viewSeed(id)).thenReturn(seed);
		Mockito.when(service.updateSeed(seed)).thenReturn(seed);
		SeedDetails details = Mockito.mock(SeedDetails.class);
		Mockito.when(util.toDetails(seed)).thenReturn(details);
		SeedDetails result = controller.updateSeedCommonName(request);
		Assertions.assertNotNull(result);
		Assertions.assertSame(details, result);
		Mockito.verify(service).viewSeed(id);
		Mockito.verify(service).updateSeed(seed);
		Mockito.verify(util).toDetails(seed);
	}

	@Test
	public void testUpdateSeedsCost() {
		int id = 1;
		Seed seed = Mockito.mock(Seed.class);
		ChangeSeedsCostRequest request = Mockito.mock(ChangeSeedsCostRequest.class);
		Mockito.when(request.getSeedId()).thenReturn(id);
		Mockito.when(request.getSeedsCost()).thenReturn(100.0);
		Mockito.when(service.viewSeed(id)).thenReturn(seed);
		Mockito.when(service.updateSeed(seed)).thenReturn(seed);
		SeedDetails details = Mockito.mock(SeedDetails.class);
		Mockito.when(util.toDetails(seed)).thenReturn(details);
		SeedDetails result = controller.updateSeedsCost(request);
		Assertions.assertNotNull(result);
		Assertions.assertSame(details, result);
		Mockito.verify(service).viewSeed(id);
		Mockito.verify(service).updateSeed(seed);
		Mockito.verify(util).toDetails(seed);
	}

	@Test
	public void testUpdateSeedsStock() {
		int id = 1;
		Seed seed = Mockito.mock(Seed.class);
		ChangeSeedsStockRequest request = Mockito.mock(ChangeSeedsStockRequest.class);
		Mockito.when(request.getSeedId()).thenReturn(id);
		Mockito.when(request.getSeedsStock()).thenReturn(20);
		Mockito.when(service.viewSeed(id)).thenReturn(seed);
		Mockito.when(service.updateSeed(seed)).thenReturn(seed);
		SeedDetails details = Mockito.mock(SeedDetails.class);
		Mockito.when(util.toDetails(seed)).thenReturn(details);
		SeedDetails result = controller.updateSeedsStock(request);
		Assertions.assertNotNull(result);
		Assertions.assertSame(details, result);
		Mockito.verify(service).viewSeed(id);
		Mockito.verify(service).updateSeed(seed);
		Mockito.verify(util).toDetails(seed);
	}

	@Test
	public void testDeleteSeed() {
		int id = 1;
		Seed seed = Mockito.mock(Seed.class);
		DeleteSeedRequest request = Mockito.mock(DeleteSeedRequest.class);
		Mockito.when(request.getSeedId()).thenReturn(id);
		Mockito.when(service.viewSeed(id)).thenReturn(seed);
		controller.deleteSeed(request);
		Mockito.verify(service).deleteSeed(seed);
	}

	@Test
	public void testFetchSeedById_1() {
		int id = 1;
		Seed seed = Mockito.mock(Seed.class);
		SeedDetails seedDetails = Mockito.mock(SeedDetails.class);
		Mockito.when(service.viewSeed(id)).thenReturn(seed);
		Mockito.when(util.toDetails(seed)).thenReturn(seedDetails);
		SeedDetails result = controller.fetchSeedById(id);
		Assertions.assertSame(seedDetails, result);
		Mockito.verify(service).viewSeed(id);
		Mockito.verify(util).toDetails(seed);
	}

	@Test
	public void testFetchSeedByName_1() {
		String name = "Mango Seed";
		Seed seed = Mockito.mock(Seed.class);
		SeedDetails seedDetails = Mockito.mock(SeedDetails.class);
		Mockito.when(service.viewSeed(name)).thenReturn(seed);
		Mockito.when(util.toDetails(seed)).thenReturn(seedDetails);
		SeedDetails result = controller.fetchSeedByName(name);
		Assertions.assertSame(seedDetails, result);
		Mockito.verify(service).viewSeed(name);
		Mockito.verify(util).toDetails(seed);
	}

	@Test
	public void testFetchAllSeeds_1() {
		List<Seed> seedList = Mockito.mock(List.class);
		List<SeedDetails> seedDetails = Mockito.mock(List.class);
		Mockito.when(service.viewAllSeeds()).thenReturn(seedList);
		Mockito.when(util.toDetailsList(seedList)).thenReturn(seedDetails);
		List<SeedDetails> result = controller.fetchAllSeeds();
		Assertions.assertSame(seedDetails, result);
		Mockito.verify(service).viewAllSeeds();
		Mockito.verify(util).toDetailsList(seedList);
	}

	@Test
	public void testFetchAllSeedsByType_1() {
		String type = "Round";
		List<Seed> seedList = Mockito.mock(List.class);
		List<SeedDetails> seedDetails = Mockito.mock(List.class);
		Mockito.when(service.viewAllSeeds(type)).thenReturn(seedList);
		Mockito.when(util.toDetailsList(seedList)).thenReturn(seedDetails);
		List<SeedDetails> result = controller.fetchAllSeedsByType(type);
		Assertions.assertSame(seedDetails, result);
		Mockito.verify(service).viewAllSeeds(type);
		Mockito.verify(util).toDetailsList(seedList);
	}

}
