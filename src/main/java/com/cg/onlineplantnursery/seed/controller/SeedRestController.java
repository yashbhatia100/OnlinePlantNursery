package com.cg.onlineplantnursery.seed.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.cg.onlineplantnursery.seed.dto.*;
import com.cg.onlineplantnursery.seed.dto.SeedDetails;
import com.cg.onlineplantnursery.seed.entity.Seed;
import com.cg.onlineplantnursery.seed.service.ISeedService;
import com.cg.onlineplantnursery.seed.util.SeedUtil;

@Validated
@RequestMapping("/seeds")
@RestController
public class SeedRestController {

	@Autowired
	private ISeedService service;

	@Autowired
	private SeedUtil util;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/addseed")
	public SeedDetails addSeed(@RequestBody CreateSeedRequest requestData) {
		Seed seed = new Seed();
		seed.setCommonName(requestData.getCommonName());
		seed.setBloomTime(requestData.getBloomTime());
		seed.setWatering(requestData.getWatering());
		seed.setDifficultyLevel(requestData.getDifficultyLevel());
		seed.setTemparature(requestData.getTemparature());
		seed.setTypeOfSeeds(requestData.getTypeOfSeeds());
		seed.setSeedsDescription(requestData.getSeedsDescription());
		seed.setSeedsStock(requestData.getSeedsStock());
		seed.setSeedsCost(requestData.getSeedsCost());
		seed.setSeedsPerPacket(requestData.getSeedsPerPacket());
		Seed created = service.addSeed(seed);
		
		SeedDetails details=util.toDetails(created);
		return details;
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping(value = "/changeseedname")
	public SeedDetails updateSeedCommonName(@RequestBody ChangeCommonNameRequest requestData) {
		Seed fetched = service.viewSeed(requestData.getSeedId());
		fetched.setCommonName(requestData.getCommonName());
		service.updateSeed(fetched);
		SeedDetails details = util.toDetails(fetched);
		return details;
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping(value = "/changeSeedsCost")
	public SeedDetails updateSeedsCost(@RequestBody ChangeSeedsCostRequest requestData) {
		Seed fetched = service.viewSeed(requestData.getSeedId());
		fetched.setSeedsCost(requestData.getSeedsCost());
		service.updateSeed(fetched);
		SeedDetails details = util.toDetails(fetched);
		return details;
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping(value = "/changeSeedsStock")
	public SeedDetails updateSeedsStock(@RequestBody ChangeSeedsStockRequest requestData) {
		Seed fetched = service.viewSeed(requestData.getSeedId());
		fetched.setSeedsStock(requestData.getSeedsStock());
		service.updateSeed(fetched);
		SeedDetails details = util.toDetails(fetched);
		return details;
	}
	
	@ResponseStatus(HttpStatus.GONE)
	@DeleteMapping(value = "/deleteSeed")
	public String deleteSeed(@RequestBody DeleteSeedRequest requestData) {
		Seed fetched = service.viewSeed(requestData.getSeedId());
		service.deleteSeed(fetched);
		return "seed is deleted for id =" + requestData.getSeedId();
	}

	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping(value = "/byseedId/{seedId}")
	public SeedDetails fetchSeedById(@PathVariable("seedId") Integer seedId) {
		Seed seed = service.viewSeed(seedId);
		SeedDetails details = util.toDetails(seed);
		return details;
	}

	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping(value = "/viewByCommonName/{commonName}")
	public SeedDetails fetchSeedByName(@PathVariable("commonName") @NotBlank String commonName) {
		Seed seed = service.viewSeed(commonName);
		SeedDetails details = util.toDetails(seed);
		return details;
	}

	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping(value = "/viewAll")
	public List<SeedDetails> fetchAllSeeds() {
		List<Seed> seedList = service.viewAllSeeds();
		List<SeedDetails> desired = util.toDetailsList(seedList);
		return desired;
	}

	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping(value = "/viewAllByTypeOfSeeds/{typeOfSeeds}")
	public List<SeedDetails> fetchAllSeedsByType(@PathVariable("typeOfSeeds") String typeOfSeeds) {
		List<Seed> seedList = service.viewAllSeeds(typeOfSeeds);
		List<SeedDetails> desired = util.toDetailsList(seedList);
		return desired;
	}

}
