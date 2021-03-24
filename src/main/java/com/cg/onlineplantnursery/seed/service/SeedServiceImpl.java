package com.cg.onlineplantnursery.seed.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.cg.onlineplantnursery.seed.entity.Seed;
import com.cg.onlineplantnursery.seed.repository.ISeedRepository;

public class SeedServiceImpl implements ISeedService{
	
	@Autowired
	private ISeedRepository repository;
	
	@Override
	public Seed addSeed(Seed seed) {
		Seed saved=repository.save(seed);
		return saved;
		
	}
	
	@Override
	public Seed updateSeed(Seed seed) {
		Seed seed1=repository.save(seed);
		return seed1;
		
	}
	
	
	
}
