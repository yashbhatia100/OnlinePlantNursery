package com.cg.onlineplantnursery.seed.repository;

import java.util.List;

import com.cg.onlineplantnursery.seed.entity.Seed;

public interface ISeedRepository {
	
	Seed save(Seed seed);
	Seed verify(Seed seed);
	
}
