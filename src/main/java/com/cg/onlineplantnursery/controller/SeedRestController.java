package com.cg.onlineplantnursery.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.dto.ChangeCommonNameRequest;
import com.cg.onlineplantnursery.dto.ChangeSeedsCostRequest;
import com.cg.onlineplantnursery.dto.ChangeSeedsStockRequest;
import com.cg.onlineplantnursery.dto.CreateSeedRequest;
import com.cg.onlineplantnursery.dto.DeleteSeedRequest;
import com.cg.onlineplantnursery.dto.SeedDetails;
import com.cg.onlineplantnursery.seed.entity.Seed;
import com.cg.onlineplantnursery.seed.service.ISeedService;
import com.cg.onlineplantnursery.util.SeedUtil;


@Validated
@RequestMapping("/seeds")
@RestController
public class SeedRestController {

	@Autowired
	private ISeedService service;

	@Autowired
	private SeedUtil util;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public SeedDetails addSeed(@RequestBody @Valid CreateSeedRequest requestData) {
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

		SeedDetails details = util.toDetails(created);
		return details;
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping(value = "/changename")
	public SeedDetails updateSeedCommonName(@RequestBody @Valid ChangeCommonNameRequest requestData) {
		Seed fetched = service.viewSeed(requestData.getSeedId());
		fetched.setCommonName(requestData.getCommonName());
		service.updateSeed(fetched);
		SeedDetails details = util.toDetails(fetched);
		return details;
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping(value = "/changecost")
	public SeedDetails updateSeedsCost(@RequestBody @Valid ChangeSeedsCostRequest requestData) {
		Seed fetched = service.viewSeed(requestData.getSeedId());
		fetched.setSeedsCost(requestData.getSeedsCost());
		service.updateSeed(fetched);
		SeedDetails details = util.toDetails(fetched);
		return details;
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping(value = "/changestock")
	public SeedDetails updateSeedsStock(@RequestBody @Valid ChangeSeedsStockRequest requestData) {
		Seed fetched = service.viewSeed(requestData.getSeedId());
		fetched.setSeedsStock(requestData.getSeedsStock());
		service.updateSeed(fetched);
		SeedDetails details = util.toDetails(fetched);
		return details;
	}

	@ResponseStatus(HttpStatus.GONE)
	@DeleteMapping(value = "/delete")
	public String deleteSeed(@RequestBody @Valid DeleteSeedRequest requestData) {
		Seed fetched = service.viewSeed(requestData.getSeedId());
		service.deleteSeed(fetched);
		return "seed is deleted for id =" + requestData.getSeedId();
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/fetch/byid/{seedId}")
	public SeedDetails fetchSeedById(@PathVariable("seedId") @NotNull Integer seedId) {
		Seed seed = service.viewSeed(seedId);
		SeedDetails details = util.toDetails(seed);
		return details;
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/fetch/bycommonname/{commonName}")
	public SeedDetails fetchSeedByName(@PathVariable("commonName") @NotBlank String commonName) {
		Seed seed = service.viewSeed(commonName);
		SeedDetails details = util.toDetails(seed);
		return details;
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/fetch")
	public List<SeedDetails> fetchAllSeeds() {
		List<Seed> seedList = service.viewAllSeeds();
		List<SeedDetails> desired = util.toDetailsList(seedList);
		return desired;
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/fetch/bytype/{typeOfSeeds}")
	public List<SeedDetails> fetchAllSeedsByType(@PathVariable("typeOfSeeds") @NotBlank String typeOfSeeds) {
		List<Seed> seedList = service.viewAllSeeds(typeOfSeeds);
		List<SeedDetails> desired = util.toDetailsList(seedList);
		return desired;
	}

}
