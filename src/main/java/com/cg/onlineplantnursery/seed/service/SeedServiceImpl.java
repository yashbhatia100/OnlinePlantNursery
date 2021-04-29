package com.cg.onlineplantnursery.seed.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlineplantnursery.seed.entity.Seed;
import com.cg.onlineplantnursery.seed.repository.ISeedRepository;
import com.cg.onlineplantnursery.exceptions.*;
import org.slf4j.*;

@Service
public class SeedServiceImpl implements ISeedService {
	
	private static final Logger Log= LoggerFactory.getLogger(SeedServiceImpl.class);

	@Autowired
	private ISeedRepository repository;

	/*
	 * add seed object
	 */
	@Transactional
	@Override
	public Seed addSeed(Seed seed) {
		Log.debug("Inside add seed");
		validateSeed(seed);
		Seed saved = repository.save(seed);
		return saved;

	}

	/*
	 * update seed object
	 */
	@Transactional
	@Override
	public Seed updateSeed(Seed seed) {
		Log.debug("Inside update seed");
		validateSeedById(seed);
		Seed seed1 = repository.save(seed);
		return seed1;

	}

	/*
	 * delete seed object
	 */
	@Transactional
	@Override
	public Seed deleteSeed(Seed seed) {
		Log.debug("Inside delete Order");
		validateSeedById(seed);
		repository.delete(seed);
		return seed;
	}

	/*
	 * view seed object by seedId
	 */
	@Override
	public Seed viewSeed(int seedId) {
		Log.debug("Inside view seed with "+seedId);
		validateSeedId(seedId);
		Optional<Seed> optional = repository.findById(seedId);
		if (!optional.isPresent()) {
			throw new SeedNotFoundException("Seed does not exist");
		}
		return optional.get();
	}

	/*
	 * view seed object by commonName
	 */
	@Override
	public Seed viewSeed(String commonName) {
		Log.debug("Inside view seed with "+commonName);
		validateCommonName(commonName);
		boolean exists = repository.existsByCommonName(commonName);
		if (!exists) {
			throw new SeedNotFoundException("Seed does not exist");
		}
		return repository.findSeedByCommonName(commonName);
	}

	/*
	 * view all seed objects
	 */
	@Override
	public List<Seed> viewAllSeeds() {
		Log.debug("Inside view  all seed  ");
		List<Seed> seedList = repository.findAll();
		if (seedList.isEmpty()) {
			throw new SeedNotFoundException("Seedlist not found");

		}
		return seedList;
	}

	/*
	 * view all seed objects by typeOfSeeds
	 */
	@Override
	public List<Seed> viewAllSeeds(String typeOfSeeds) {
		Log.debug("Inside view  all seed  with "+typeOfSeeds);
		validateSeedByType(typeOfSeeds);
		List<Seed> seedList = repository.findAllByTypeOfSeeds(typeOfSeeds);
		if (seedList.isEmpty()) {
			throw new SeedNotFoundException("Seedlist not found");
		}
		return seedList;
	}

	public void validateSeed(Seed seed) {
		if (seed == null) {
			throw new SeedAddException("Null seed");
		}
		if (seed.getCommonName().equals("")) {
			throw new InvalidSeedNameException("Seed name cannot be empty");
		}
		if (seed.getTypeOfSeeds().equals("")) {
			throw new InvalidSeedTypeException("Seed type cannot be empty");
		}
		if (seed.getSeedsCost() < 0) {
			throw new InvalidSeedsCostException("Seed cost must be greater than 0");
		}
		if (seed.getSeedsStock() < 0) {
			throw new InvalidSeedsStockException("Seed cost must be greater than 0");
		}
	}

	public void validateSeedById(Seed seed) {
		Integer id = seed.getSeedId();
		boolean exists = repository.existsById(id);
		if (!exists) {
			throw new SeedNotFoundException("Seed does not exists for id=" + id);
		}
	}

	public void validateSeedId(Integer id) {
		if (id < 0) {
			throw new InvalidSeedIdException("invalid seed id");
		}
	}

	public void validateCommonName(String commonName) {
		if (commonName.equals("")) {
			throw new InvalidSeedNameException("Seed name is empty");
		}
	}

	public void validateSeedByType(String typeOfSeeds) {
		if (typeOfSeeds.equals("")) {
			throw new InvalidSeedTypeException("Seed type is empty ");
		}
	}

}