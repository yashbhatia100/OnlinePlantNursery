package com.cg.onlineplantnursery.seed;

import com.cg.onlineplantnursery.seed.repository.ISeedRepository;
import com.cg.onlineplantnursery.seed.service.SeedServiceImpl;
import com.cg.onlineplantnursery.seed.entity.Seed;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
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
	
	@Test
	public void testAddSeed_1() {
		Seed seed=Mockito.mock(Seed.class);
		Seed saved=Mockito.mock(Seed.class);
		Mockito.when(repository.save(seed)).thenReturn(saved);
		Seed result=service.addSeed(seed);
		Assertions.assertEquals(seed,result);
		Mockito.verify(repository).save(seed);
	}
	
	@Test
	public void testUpdate_1() {
		Seed seed = Mockito.mock(Seed.class);
		Mockito.when(repository.save(seed)).thenReturn(seed);
		Seed result=service.updateSeed(seed);
		Assertions.assertEquals(seed,result);
		Mockito.verify(repository).save(seed);
	}
	

}
