package com.cg.onlineplantnursery.planter.ui;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.repository.IPlanterRepository;
import com.cg.onlineplantnursery.planter.service.IPlanterService;

@Component
public class PlanterConsoleUi {

	@Autowired
	IPlanterService planterService;

	@Autowired
	IPlanterRepository planterRepository;

	public void start() {

		System.out.println("\n***********Planters**********\n");

		Planter planter1 = new Planter(10.0f, 10, 1, "Red", "Cylinderical", 10, 150);
		Planter planter2 = new Planter(11.0f, 15, 2, "Green", "Square", 12, 250);
		Planter planter3 = new Planter(12.0f, 20, 3, "Yellow", "Rectangular", 14, 300);
		planterService.addPlanter(planter1);
		planterService.addPlanter(planter2);
		planterService.addPlanter(planter3);

		System.out.println("\n**************Planter by Id********\n");
		Planter fetchedPlanter = planterService.viewPlanter(planter2.getPlanterId());
		System.out.println("Displaying Planter for the fetched id " + planter2.getPlanterId());
		display(fetchedPlanter);

		System.out.println("\n**************Planter by Shape********\n");
		List<Planter> plantersList = planterService.viewPlanter("Square");
		displayAll(plantersList);

		System.out.println("\n*********Displaying all the Planters*********\n");
		List<Planter> list = planterService.viewAllPlanters();
		displayAll(list);

		System.out.println("\n***********Deleting the planter******\n");
		System.out.println("Planter is deleted for the id " + planter3.getPlanterId());
		planterService.deletePlanter(planter3);
		
		
		System.out.println("\n************Updating the planter**********\n");
		planterService.updatePlanter(planter2);
		
		display(planter2);
		
		
		
		System.out.println("\n*************Displaying by the Cost*********\n");
		List<Planter>planterList=planterService.viewAllPlanters(100.0d, 300.0d);
		displayAll(planterList);
	}

	public void display(Planter planter) {
		System.out.println(planter);

	}

	public void displayAll(Collection<Planter> planters) {
		for (Planter planter : planters)
			display(planter);
	}

}
