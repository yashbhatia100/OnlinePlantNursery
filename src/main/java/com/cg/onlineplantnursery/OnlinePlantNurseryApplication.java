package com.cg.onlineplantnursery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.onlineplantnursery.customer.ui.CustomerUI;

@SpringBootApplication
public class OnlinePlantNurseryApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OnlinePlantNurseryApplication.class, args);
		CustomerUI project = context.getBean(CustomerUI.class);
		project.start();
	}

}



/*package com.cg.onlineplantnursery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.cg.onlineplantnursery.customer.ui.CustomerUI;



@SpringBootApplication
public class OnlinePlantNurseryApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OnlinePlantNurseryApplication.class, args);
		CustomerUI project = context.getBean(CustomerUI.class);
		project.start();

	}

}*/
