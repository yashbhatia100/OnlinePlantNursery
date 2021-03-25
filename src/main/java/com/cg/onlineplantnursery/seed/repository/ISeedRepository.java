package com.cg.onlineplantnursery.seed.repository;

import java.util.List;

import com.cg.onlineplantnursery.seed.entity.Seed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeedRepository extends JpaRepository<Seed, Integer> {

	List<Seed> viewAllSeeds();

	List<Seed> viewAllSeeds(String typeOfSeed);
}