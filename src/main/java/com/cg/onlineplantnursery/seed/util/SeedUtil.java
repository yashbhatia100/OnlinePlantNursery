package com.cg.onlineplantnursery.seed.util;

import java.util.*;
import org.springframework.stereotype.Component;

import com.cg.onlineplantnursery.seed.dto.SeedDetails;
import com.cg.onlineplantnursery.seed.entity.Seed;

@Component
public class SeedUtil {

	public SeedDetails toDetails(Seed seed) {
		SeedDetails details = new SeedDetails();
		details.setSeedId(seed.getSeedId());
		details.setCommonName(seed.getCommonName());
		details.setBloomTime(seed.getBloomTime());
		details.setWatering(seed.getWatering());
		details.setDifficultyLevel(seed.getDifficultyLevel());
		details.setTemparature(seed.getTemparature());
		details.setTypeOfSeeds(seed.getTypeOfSeeds());
		details.setSeedsDescription(seed.getSeedsDescription());
		details.setSeedsStock(seed.getSeedsStock());
		details.setSeedsCost(seed.getSeedsCost());
		details.setSeedsPerPacket(seed.getSeedsPerPacket());
		return details;

	}

	public List<SeedDetails> toDetailsList(Collection<Seed> seeds) {
		List<SeedDetails> desired = new ArrayList<>();
		for (Seed seed : seeds) {
			SeedDetails details = toDetails(seed);
			desired.add(details);
		}
		return desired;

	}

}
