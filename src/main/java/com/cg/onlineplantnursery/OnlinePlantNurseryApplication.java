package com.cg.onlineplantnursery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.onlineplantnursery.seed.ui.SeedUI;

@SpringBootApplication
public class OnlinePlantNurseryApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OnlinePlantNurseryApplication.class, args);

		SeedUI app = context.getBean(SeedUI.class);
		app.start();
	}

}
