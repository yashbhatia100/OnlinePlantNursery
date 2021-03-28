package com.cg.onlineplantnursery.planter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.planter.dto.PlanterDetails;
import com.cg.onlineplantnursery.planter.repository.IPlanterRepository;
import com.cg.onlineplantnursery.planter.service.IPlanterService;
import com.cg.onlineplantnursery.planter.util.PlanterUtil;


@RequestMapping("/planter")
@RestController
public class PlanterRestController {
	
	@Autowired
	IPlanterRepository planterRepository;
	
	@Autowired
	private IPlanterService planterService;
	
	@Autowired
	private PlanterUtil util;
	
	
	
	@GetMapping("/findbyid/{id}")
	public PlanterDetails viewPlanter(@PathVariable int id) {
		return util.toDetails(planterService.viewPlanter(id));
	}

}
