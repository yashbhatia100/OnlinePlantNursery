
package com.cg.onlineplantnursery.seed.ui;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.onlineplantnursery.seed.repository.ISeedRepository;
import com.cg.onlineplantnursery.seed.service.*;
import com.cg.onlineplantnursery.seed.entity.Seed;

@Component
public class SeedMain {
	@Autowired
	private ISeedService service;
	
	public static void main(String args[]) {
		
	}
	
	public void start() {
		
		
	}
}
