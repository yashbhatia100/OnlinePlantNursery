package com.cg.onlineplantnursery.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.onlineplantnursery.dto.PlanterDetails;
import com.cg.onlineplantnursery.planter.entity.Planter;

@Component
public class PlanterUtil {
	/*
	 * Converting Planter Object to planter Details DTO Object
	*/
	public PlanterDetails toDetails(Planter planter) {
		PlanterDetails details = new PlanterDetails();
		details.setPlanterId(planter.getPlanterId());
		details.setPlanterHeight(planter.getPlanterHeight());
		details.setPlanterCapacity(planter.getPlanterCapacity());
		details.setPlanterColor(planter.getPlanterColor());
		details.setPlanterShape(planter.getPlanterShape());
		details.setPlanterStock(planter.getPlanterStock());
		details.setDrainageHoles(planter.getDrainageHoles());
		details.setPlanterCost(planter.getPlanterCost());

		return details;

	}

	/*
	 * Converting  List of Planter to planter Details DTO 
	*/
	public List<PlanterDetails> toDetailsList(List<Planter> planters) {
		List<PlanterDetails> desired = new ArrayList<>();
		for (Planter planter : planters) {
			PlanterDetails details = toDetails(planter);
			desired.add(details);
		}

		return desired;

	}

}