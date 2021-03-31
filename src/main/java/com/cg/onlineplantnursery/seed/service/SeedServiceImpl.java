package com.cg.onlineplantnursery.seed.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlineplantnursery.seed.entity.Seed;
import com.cg.onlineplantnursery.seed.repository.ISeedRepository;
import com.cg.onlineplantnursery.exceptions.*;

@Service
public class SeedServiceImpl implements ISeedService {

	@Autowired
	private ISeedRepository repository;

	/*
	 * add seed object
	 */
	@Transactional
	@Override
	public Seed addSeed(Seed seed) {
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
		validateSeedById(seed);
		repository.delete(seed);
		return seed;
	}

	/*
	 * view seed object by seedId
	 */
	@Override
	public Seed viewSeed(int seedId) {
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