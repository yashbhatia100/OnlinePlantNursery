package com.cg.onlineplantnursery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.onlineplantnursery.ui.CustomerUI;
import com.cg.onlineplantnursery.ui.OrderUi;
import com.cg.onlineplantnursery.ui.PlantUI;
import com.cg.onlineplantnursery.ui.PlanterUi;
import com.cg.onlineplantnursery.ui.SeedUI;

@SpringBootApplication
public class OnlinePlantNurseryApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OnlinePlantNurseryApplication.class, args);
		
		PlantUI app1 = context.getBean(PlantUI.class);
		app1.start();
		
		//SeedUI app2 = context.getBean(SeedUI.class);
		//app2.start();
		
		//PlanterUi app3 = context.getBean(PlanterUi.class);
		//app3.start();
		
		//CustomerUI app4 = context.getBean(CustomerUI.class);
		//app4.start();
		
		//OrderUi app5 = context.getBean(OrderUi.class);
		//app5.start();
	}

}
