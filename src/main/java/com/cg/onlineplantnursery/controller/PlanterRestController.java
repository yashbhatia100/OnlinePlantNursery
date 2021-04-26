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

import com.cg.onlineplantnursery.dto.AddPlanterRequest;
import com.cg.onlineplantnursery.dto.DeletePlanterRequest;
import com.cg.onlineplantnursery.dto.PlanterDetails;
import com.cg.onlineplantnursery.dto.UpdatePlanterCapacityRequest;
import com.cg.onlineplantnursery.dto.UpdatePlanterColorRequest;
import com.cg.onlineplantnursery.dto.UpdatePlanterCostRequest;
import com.cg.onlineplantnursery.dto.UpdatePlanterDrainageHolesRequest;
import com.cg.onlineplantnursery.dto.UpdatePlanterHeightRequest;
import com.cg.onlineplantnursery.dto.UpdatePlanterShapeRequest;
import com.cg.onlineplantnursery.dto.UpdatePlanterStockRequest;
import com.cg.onlineplantnursery.plant.service.IPlantService;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.service.IPlanterService;
import com.cg.onlineplantnursery.seed.service.ISeedService;
import com.cg.onlineplantnursery.util.PlanterUtil;

@Validated
@RequestMapping("/planter")
@RestController
public class PlanterRestController {

	@Autowired
	private IPlanterService planterService;
	
	@Autowired
	private IPlantService plantService;
	
	@Autowired
	private ISeedService seedService;

	@Autowired
	private PlanterUtil util;

	/*
	 * Rest controller for adding the planter object to database Call:
	 * planterService.addPlanter() and util.toDetails()
	 */
	@Validated
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public PlanterDetails addPlanter(@RequestBody @Valid AddPlanterRequest requestData) {
		Planter planter = new Planter();
		planter.setDrainageHoles(requestData.getDrainageHoles());
		planter.setPlanterCapacity(requestData.getPlanterCapacity());
		planter.setPlanterHeight(requestData.getPlanterHeight());
		planter.setPlanterColor(requestData.getPlanterColor());
		planter.setPlanterShape(requestData.getPlanterShape());
		planter.setPlanterCost(requestData.getPlanterCost());
		planter.setPlanterStock(requestData.getPlanterStock());
		if(requestData.getPlantId()>0)
		{
		planter.setPlant(plantService.viewPlant(requestData.getPlantId()));
		}
		if(requestData.getSeedId()>0)
		{
		planter.setSeed(seedService.viewSeed(requestData.getSeedId()));
		
		}
		Planter saved = planterService.addPlanter(planter);
		PlanterDetails details = util.toDetails(saved);
		return details;

	}

	/*
	 * Rest controller for fetching the planter by id Call:
	 * planterService.viewPlanter() and util.toDetails()
	 */

	@GetMapping("/fetch/byid/{id}")
	public PlanterDetails viewPlanterById(@PathVariable @NotNull int id) {
		return util.toDetails(planterService.viewPlanter(id));
	}

	/*
	 * Rest controller for fetching the planter by PlanterShape
	 * Call:planterService.viewPlanter() and util.toDetails()
	 */

	@GetMapping("/fetch/byshape/{planterShape}")
	public List<PlanterDetails> viewPlannterByplanterShape(
			@PathVariable("planterShape") @NotBlank String planterShape) {

		List<Planter> plantersList = planterService.viewPlanter(planterShape);
		List<PlanterDetails> desired = util.toDetailsList(plantersList);

		return desired;

	}

	/*
	 * Rest controller for viewing the planter from the database Call:
	 * planterService.viewAllPlanters() and util.toDetails()
	 */

	@GetMapping("/fetch")
	public List<PlanterDetails> findAllPlannter() {

		List<Planter> plantersList = planterService.viewAllPlanters();
		List<PlanterDetails> desired = util.toDetailsList(plantersList);
		return desired;

	}

	/*
	 * Rest controller for fetching the planter by id
	 * Call:planterService.viewPlanter(minCost,maxCost) and util.toDetails()
	 */

	@GetMapping("/fetch/bycost/{minCost}/{maxCost}")
	public List<PlanterDetails> findAllPlannterByCost(@PathVariable("minCost") @NotNull int minCost,
			@PathVariable("maxCost") @NotNull int maxCost) {

		List<Planter> plantersList = planterService.viewAllPlanters(minCost, maxCost);
		List<PlanterDetails> desired = util.toDetailsList(plantersList);
		return desired;

	}

	/*
	 * Rest controller for fetching the planter by id Call:
	 * planterService.viewPlanter() and planterService.deltePlanter and
	 * util.toDetails()
	 */

	@DeleteMapping("/delete")
	public String delete(@RequestBody @Valid DeletePlanterRequest requestData) {
		Planter planter = planterService.viewPlanter(requestData.getPlanterId());
		planterService.deletePlanter(planter);
		return "planter is deleted for the " + requestData.getPlanterId();

	}

	/*
	 * Rest controller for fetching the planter by id Call:
	 * planterService.viewPlanter() and planterService.updatePlanter and
	 * util.toDetails()
	 */

	@PutMapping("/updateheight")
	public PlanterDetails updatePlanterHeight(@RequestBody @Valid UpdatePlanterHeightRequest requestData) {
		Planter planter = planterService.viewPlanter(requestData.getPlanterId());
		planter.setPlanterHeight(requestData.getPlanterHeight());
		planterService.updatePlanter(planter);
		return util.toDetails(planter);
	}

	/*
	 * Rest controller for fetching the planter by id Call:
	 * planterService.viewPlanter() and planterService.updatePlanter and
	 * util.toDetails()
	 */

	@PutMapping("/updatecapacity")
	public PlanterDetails updatePlanterCapacity(@RequestBody @Valid UpdatePlanterCapacityRequest requestData) {
		Planter planter = planterService.viewPlanter(requestData.getPlanterId());
		planter.setPlanterCapacity(requestData.getPlanterCapacity());
		planterService.updatePlanter(planter);
		return util.toDetails(planter);
	}

	/*
	 * Rest controller for fetching the planter by id Call:
	 * planterService.viewPlanter() and planterService.updatePlanter and
	 * util.toDetails()
	 */

	@PutMapping("/updatedrainageholes")
	public PlanterDetails updateDrainageHoles(@RequestBody @Valid UpdatePlanterDrainageHolesRequest requestData) {
		Planter planter = planterService.viewPlanter(requestData.getPlanterId());
		planter.setDrainageHoles(requestData.getDrainageHoles());
		planterService.updatePlanter(planter);
		return util.toDetails(planter);
	}

	/*
	 * Rest controller for fetching the planter by id Call:
	 * planterService.viewPlanter() and planterService.updatePlanter and
	 * util.toDetails()
	 */

	@PutMapping("/updatecolor")
	public PlanterDetails updatePlanterColor(@RequestBody @Valid UpdatePlanterColorRequest requestData) {
		Planter planter = planterService.viewPlanter(requestData.getPlanterId());
		planter.setPlanterColor(requestData.getPlanterColor());
		planterService.updatePlanter(planter);
		return util.toDetails(planter);
	}

	/*
	 * Rest controller for fetching the planter by id Call:
	 * planterService.viewPlanter() and planterService.updatePlanter and
	 * util.toDetails()
	 */

	@PutMapping("/updateshape")
	public PlanterDetails updatePlanterShape(@RequestBody @Valid UpdatePlanterShapeRequest requestData) {
		Planter planter = planterService.viewPlanter(requestData.getPlanterId());
		planter.setPlanterShape(requestData.getPlanterShape());
		planterService.updatePlanter(planter);
		return util.toDetails(planter);
	}

	/*
	 * Rest controller for fetching the planter by id Call:
	 * planterService.viewPlanter() and planterService.updatePlanter and
	 * util.toDetails()
	 */

	@PutMapping("/updatestock")
	public PlanterDetails updatePlanterStock(@RequestBody @Valid UpdatePlanterStockRequest requestData) {
		Planter planter = planterService.viewPlanter(requestData.getPlanterId());
		planter.setPlanterStock(requestData.getPlanterStock());
		planterService.updatePlanter(planter);
		return util.toDetails(planter);
	}

	/*
	 * Rest controller for fetching the planter by id Call:
	 * planterService.viewPlanter() and planterService.updatePlanter and
	 * util.toDetails()
	 */

	@PutMapping("/updatecost")
	public PlanterDetails updatePlanterCost(@RequestBody @Valid UpdatePlanterCostRequest requestData) {
		Planter planter = planterService.viewPlanter(requestData.getPlanterId());
		planter.setPlanterCost(requestData.getPlanterCost());
		planterService.updatePlanter(planter);
		return util.toDetails(planter);
	}

}
