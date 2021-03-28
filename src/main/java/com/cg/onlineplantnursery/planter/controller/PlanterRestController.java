package com.cg.onlineplantnursery.planter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.planter.dto.AddPlanterRequest;
import com.cg.onlineplantnursery.planter.dto.PlanterDetails;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.service.IPlanterService;
import com.cg.onlineplantnursery.planter.util.PlanterUtil;

@RequestMapping("/planter")
@RestController
public class PlanterRestController {

	@Autowired
	private IPlanterService planterService;

	@Autowired
	private PlanterUtil util;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public String addPlanter(@RequestBody AddPlanterRequest requestData) {
		Planter planter = new Planter();
		planter.setDrainageHoles(requestData.getDrainageHoles());
		planter.setPlanterCapacity(requestData.getPlanterCapacity());
		planter.setPlanterHeight(requestData.getPlanterHeight());
		planter.setPlanterColor(requestData.getPlanterColor());
		planter.setPlanterShape(requestData.getPlanterShape());
		planter.setPlanterCost(requestData.getPlanterCost());
		planter.setPlanterStock(requestData.getPlanterStock());
		planterService.addPlanter(planter);
		return "planter is created with " + planter.getPlanterId();

	}

	@GetMapping("/findbyid/{id}")
	public PlanterDetails viewPlanterById(@PathVariable int id) {
		return util.toDetails(planterService.viewPlanter(id));
	}
	

}
