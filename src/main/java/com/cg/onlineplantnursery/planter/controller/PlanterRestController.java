package com.cg.onlineplantnursery.planter.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.planter.dto.AddPlanterRequest;
import com.cg.onlineplantnursery.planter.dto.DeletePlanterRequest;
import com.cg.onlineplantnursery.planter.dto.PlanterDetails;
import com.cg.onlineplantnursery.planter.dto.UpdatePlanterCapacityRequest;
import com.cg.onlineplantnursery.planter.dto.UpdatePlanterColorRequest;
import com.cg.onlineplantnursery.planter.dto.UpdatePlanterCostRequest;
import com.cg.onlineplantnursery.planter.dto.UpdatePlanterDrainageHolesRequest;
import com.cg.onlineplantnursery.planter.dto.UpdatePlanterHeightRequest;
import com.cg.onlineplantnursery.planter.dto.UpdatePlanterShapeRequest;
import com.cg.onlineplantnursery.planter.dto.UpdatePlanterStockRequest;
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

	/*
	 * Rest controller for adding the planter object to database
	 * Call: planterService.addPlanter() and util.toDetails()
	 */

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public PlanterDetails addPlanter(@RequestBody AddPlanterRequest requestData) {
		Planter planter = new Planter();
		planter.setDrainageHoles(requestData.getDrainageHoles());
		planter.setPlanterCapacity(requestData.getPlanterCapacity());
		planter.setPlanterHeight(requestData.getPlanterHeight());
		planter.setPlanterColor(requestData.getPlanterColor());
		planter.setPlanterShape(requestData.getPlanterShape());
		planter.setPlanterCost(requestData.getPlanterCost());
		planter.setPlanterStock(requestData.getPlanterStock());
		Planter saved =planterService.addPlanter(planter);
		PlanterDetails details=util.toDetails(saved);
		return details;

	}
	
	
	/*
	 * Rest controller for fetching the planter by id
	 * Call: planterService.viewPlanter() and util.toDetails()
	 */

	@GetMapping("/findbyid/{id}")
	public PlanterDetails viewPlanterById(@PathVariable int id) {
		return util.toDetails(planterService.viewPlanter(id));
	}
	
	/*
	 * Rest controller for fetching the planter by PlanterShape
	 * Call:planterService.viewPlanter() and util.toDetails()
	 */

	

	@GetMapping("/findbyPlanterShape/{planterShape}")
	public List<PlanterDetails> viewPlannterByplanterShape(
			@PathVariable("planterShape") @NotBlank String planterShape) {

		List<Planter> plantersList = planterService.viewPlanter(planterShape);
		List<PlanterDetails> desired = util.toDetailsList(plantersList);

		return desired;

	}
	
	/*
	 * Rest controller for viewing  the planter from the database
	 * Call: planterService.viewAllPlanters() and util.toDetails()
	 */


	@GetMapping("/viewAll")
	public List<PlanterDetails> findAllPlannter() {

		List<Planter> plantersList = planterService.viewAllPlanters();
		List<PlanterDetails> desired = util.toDetailsList(plantersList);
		return desired;

	}

	/*
	 * Rest controller for fetching the planter by id
	 * Call:planterService.viewPlanter(minCost,maxCost) and util.toDetails()
	 */

	
	@GetMapping("/viewAllByplanterCost/{minCost}/{maxCost}")
	public List<PlanterDetails> findAllPlannterByCost(@PathVariable("minCost") int minCost,
			@PathVariable("maxCost") int maxCost) {

		List<Planter> plantersList = planterService.viewAllPlanters(minCost, maxCost);
		List<PlanterDetails> desired = util.toDetailsList(plantersList);
		return desired;

	}
	
	/*
	 * Rest controller for fetching the planter by id
	 * Call: planterService.viewPlanter() and planterService.deltePlanter  and util.toDetails()
	 */


	@DeleteMapping("/Delete")
	public String delete(@RequestBody DeletePlanterRequest requestData) {
		Planter planter=planterService.viewPlanter(requestData.getPlanterId());
		planterService.deletePlanter(planter);
		return "planter is deleted for the " + requestData.getPlanterId();

	}
	
	/*
	 * Rest controller for fetching the planter by id
	 * Call: planterService.viewPlanter() and planterService.updatePlanter and util.toDetails()
	 */


	@PutMapping("/UpdatePlanterHeight")
	public PlanterDetails updatePlanterHeight(@RequestBody UpdatePlanterHeightRequest requestData) {
		Planter planter = planterService.viewPlanter(requestData.getPlanterId());
		planter.setPlanterHeight(requestData.getPlanterHeight());
		planterService.updatePlanter(planter);
		return util.toDetails(planter);
	}
	
	/*
	 * Rest controller for fetching the planter by id
	 * Call: planterService.viewPlanter() and planterService.updatePlanter and util.toDetails()
	 */

	@PutMapping("/UpdatePlanterCapacity")
	public PlanterDetails updatePlanterCapacity(@RequestBody UpdatePlanterCapacityRequest requestData) {
		Planter planter = planterService.viewPlanter(requestData.getPlanterId());
		planter.setPlanterCapacity(requestData.getPlanterCapacity());
		planterService.updatePlanter(planter);
		return util.toDetails(planter);
	}
	
	/*
	 * Rest controller for fetching the planter by id
	 * Call: planterService.viewPlanter() and planterService.updatePlanter and util.toDetails()
	 */

	@PutMapping("/UpdatePlanterDrainageHoles")
	public PlanterDetails updateDrainageHoles(@RequestBody UpdatePlanterDrainageHolesRequest requestData) {
		Planter planter = planterService.viewPlanter(requestData.getPlanterId());
		planter.setDrainageHoles(requestData.getDrainageHoles());
		planterService.updatePlanter(planter);
		return util.toDetails(planter);
	}
	
	/*
	 * Rest controller for fetching the planter by id
	 * Call: planterService.viewPlanter() and planterService.updatePlanter and util.toDetails()
	 */

	@PutMapping("/UpdatePlanterColor")
	public PlanterDetails updatePlanterColor(@RequestBody UpdatePlanterColorRequest requestData) {
		Planter planter = planterService.viewPlanter(requestData.getPlanterId());
		planter.setPlanterColor(requestData.getPlanterColor());
		planterService.updatePlanter(planter);
		return util.toDetails(planter);
	}
	
	/*
	 * Rest controller for fetching the planter by id
	 * Call: planterService.viewPlanter() and planterService.updatePlanter and util.toDetails()
	 */

	@PutMapping("/UpdatePlanterShape")
	public PlanterDetails updatePlanterShape(@RequestBody UpdatePlanterShapeRequest requestData) {
		Planter planter = planterService.viewPlanter(requestData.getPlanterId());
		planter.setPlanterShape(requestData.getPlanterShape());
		planterService.updatePlanter(planter);
		return util.toDetails(planter);
	}
	
	/*
	 * Rest controller for fetching the planter by id
	 * Call: planterService.viewPlanter() and planterService.updatePlanter and util.toDetails()
	 */

	@PutMapping("/UpdatePlanterStock")
	public PlanterDetails updatePlanterStock(@RequestBody UpdatePlanterStockRequest requestData) {
		Planter planter = planterService.viewPlanter(requestData.getPlanterId());
		planter.setPlanterStock(requestData.getPlanterStock());
		planterService.updatePlanter(planter);
		return util.toDetails(planter);
	}

	/*
	 * Rest controller for fetching the planter by id
	 * Call: planterService.viewPlanter() and planterService.updatePlanter and util.toDetails()
	 */
	
	@PutMapping("/UpdatePlanterCost")
	public PlanterDetails updatePlanterCost(@RequestBody UpdatePlanterCostRequest requestData) {
		Planter planter = planterService.viewPlanter(requestData.getPlanterId());
		planter.setPlanterCost(requestData.getPlanterCost());
		planterService.updatePlanter(planter);
		return util.toDetails(planter);
	}

}
