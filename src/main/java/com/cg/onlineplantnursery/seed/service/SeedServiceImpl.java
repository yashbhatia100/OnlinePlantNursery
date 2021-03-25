package com.cg.onlineplantnursery.seed.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.cg.onlineplantnursery.seed.entity.Seed;
import com.cg.onlineplantnursery.seed.repository.ISeedRepository;
import com.cg.onlineplantnursery.exceptions.*;

public class SeedServiceImpl implements ISeedService {

	@Autowired
	private ISeedRepository repository;

	@Override
	public Seed addSeed(Seed seed) {
		if (seed == null) {
			throw new SeedAddException("Null seed");
		}
		Seed saved = repository.save(seed);
		return saved;

	}

	@Override
	public Seed updateSeed(Seed seed) {
		Integer id = seed.getSeedId();
		boolean exists = repository.existsById(id);
		if (!exists) {
			throw new SeedUpdateException("Seed does not exists for id=" + id);
		}
		Seed seed1 = repository.save(seed);
		return seed1;

	}

	public Seed deleteSeed(Seed seed) {
		return null;
	}

	public Seed viewSeed(int seedId) {
		return null;
	}

	public Seed viewSeed(String commonName) {
		return null;
	}

	public List<Seed> viewAllSeeds() {
		List<Seed> seedList = repository.viewAllSeeds();
		if (seedList.isEmpty()) {
			throw new SeedNotFoundException("Seedlist not found");

		}
		return seedList;
	}

	public List<Seed> viewAllSeeds(String typeOfSeed) {
		List<Seed> seedList = repository.viewAllSeeds(typeOfSeed);
		if (seedList.isEmpty()) {
			throw new SeedTypeNotFoundException("Seedlist not found");
		}
		return seedList;
	}

}
