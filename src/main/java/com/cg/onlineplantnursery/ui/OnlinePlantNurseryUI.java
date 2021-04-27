package com.cg.onlineplantnursery.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlineplantnursery.customer.entity.Address;
import com.cg.onlineplantnursery.customer.entity.Customer;
import com.cg.onlineplantnursery.customer.service.ICustomerService;
import com.cg.onlineplantnursery.order.entity.Order;
import com.cg.onlineplantnursery.order.service.IOrderService;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.plant.service.IPlantService;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.service.IPlanterService;
import com.cg.onlineplantnursery.seed.entity.Seed;
import com.cg.onlineplantnursery.seed.service.ISeedService;

@Component
public class OnlinePlantNurseryUI {
	
		@Autowired
		private IPlantService plantService;
		
		@Autowired
		private ISeedService seedService;
		
		@Autowired
		private IPlanterService planterService;
		
		@Autowired
		ICustomerService customerService;
		
		@Autowired
		private IOrderService orderService;
		
		public void start() {
			
			Plant plant1 = new Plant();
			Plant plant2 = new Plant();
			Plant plant3 = new Plant();
			
			plant1.setPlantHeight(10);
			plant1.setPlantSpread("50cm");
			plant1.setCommonName("Sunflower");
			plant1.setBloomTime("2months");
			plant1.setMedicinalOrCulinaryUse("Improves immunity");
			plant1.setDifficultyLevel("Easy");
			plant1.setTemperature("26deg");
			plant1.setTypeOfPlant("Shrub");
			plant1.setPlantDescription("Yellow colored sun facing flowers");
			plant1.setPlantsStock(10);
			plant1.setPlantCost(50.0);
			
			plant2.setPlantHeight(20);
			plant2.setPlantSpread("40cm");
			plant2.setCommonName("Rose");
			plant2.setBloomTime("3months");
			plant2.setMedicinalOrCulinaryUse("Improves taste");
			plant2.setDifficultyLevel("Moderate");
			plant2.setTemperature("30deg");
			plant2.setTypeOfPlant("Herb");
			plant2.setPlantDescription("Red colored flowers with sweet smell");
			plant2.setPlantsStock(10);
			plant2.setPlantCost(70.0);
			
			plant3.setPlantHeight(1000);
			plant3.setPlantSpread("10m");
			plant3.setCommonName("Mango");
			plant3.setBloomTime("1year");
			plant3.setMedicinalOrCulinaryUse("Used as fruit");
			plant3.setDifficultyLevel("Difficult");
			plant3.setTemperature("30deg");
			plant3.setTypeOfPlant("Shrub");
			plant3.setPlantDescription("Provides the mango fruit");
			plant3.setPlantsStock(20);
			plant3.setPlantCost(500.0);
			
			plantService.addPlant(plant1);
			plantService.addPlant(plant2);
			plantService.addPlant(plant3);
			
			final String Monocotyledonous = "monocotyledonous";
			final String Dicotyledonous = "dicotyledonous";
	
			Seed seed1 = new Seed();
			Seed seed2 = new Seed();
			Seed seed3 = new Seed();
	
			seed1.setCommonName("Rose seed");
			seed1.setBloomTime("3days");
			seed1.setWatering("Misting");
			seed1.setDifficultyLevel("Easy");
			seed1.setTemparature("25deg");
			seed1.setTypeOfSeeds(Monocotyledonous);
			seed1.setSeedsDescription("Red rose seeds");
			seed1.setSeedsStock(20);
			seed1.setSeedsCost(100.0);
			seed1.setSeedsPerPacket(20);
	
			seed2.setCommonName("Potato seed");
			seed2.setBloomTime("4days");
			seed2.setWatering("Sprinkle");
			seed2.setDifficultyLevel("Easy");
			seed2.setTemparature("25deg");
			seed2.setTypeOfSeeds(Dicotyledonous);
			seed2.setSeedsDescription("Potato seeds");
			seed2.setSeedsStock(30);
			seed2.setSeedsCost(50.0);
			seed2.setSeedsPerPacket(10);
	
			seed3.setCommonName("Carrot seed");
			seed3.setBloomTime("5days");
			seed3.setWatering("Skin Bath");
			seed3.setDifficultyLevel("Medium");
			seed3.setTemparature("15deg");
			seed3.setTypeOfSeeds(Monocotyledonous);
			seed3.setSeedsDescription("Carrot seeds");
			seed3.setSeedsStock(10);
			seed3.setSeedsCost(60.0);
			seed3.setSeedsPerPacket(30);
	
			seedService.addSeed(seed1);
			seedService.addSeed(seed2);
			seedService.addSeed(seed3);
			
			
			final String Cylindrical = "cylindrical";
			final String Square = "square";
			final String Rectangular = "regctangular";
			
			Planter planter1 = new Planter();
			Planter planter2 = new Planter();
			Planter planter3 = new Planter();
	
			planter1.setPlanterHeight(10.0f);
			planter1.setPlanterCapacity(10);
			planter1.setDrainageHoles(1);
			planter1.setPlanterColor(1);
			planter1.setPlanterShape(Cylindrical);
			planter1.setPlanterStock(10);
			planter1.setPlanterCost(150);
			planter1.setPlant(plant1);
	
			planter2.setPlanterHeight(11.0f);
			planter2.setPlanterCapacity(15);
			planter2.setDrainageHoles(2);
			planter2.setPlanterColor(2);
			planter2.setPlanterShape(Square);
			planter2.setPlanterStock(12);
			planter2.setPlanterCost(400);
			planter2.setSeed(seed2);
	
			planter3.setPlanterHeight(12.0f);
			planter3.setPlanterCapacity(20);
			planter3.setDrainageHoles(3);
			planter3.setPlanterColor(3);
			planter3.setPlanterShape(Rectangular);
			planter3.setPlanterStock(14);
			planter3.setPlanterCost(300);
			planter3.setPlant(plant3);
	
			planterService.addPlanter(planter1);
			planterService.addPlanter(planter2);
			planterService.addPlanter(planter3);
			
			Address address1= new Address();
			Address address2= new Address();
			Address address3= new Address();
			
			address1.setHouseNo("M8");
			address1.setColony("Korattur");
			address1.setCity("Chennai");
			address1.setState("Tamil Nadu");
			address1.setPincode(6998086);
			
			address2.setHouseNo("Y178");
			address2.setColony("Laxmi Nagar");
			address2.setCity(" South Delhi ");
			address2.setState("Delhi");
			address2.setPincode(69980342);
			
			address3.setHouseNo("BA3");
			address3.setColony("Dayalbagh");
			address3.setCity("Agra");
			address3.setState("Uttar Pradesh");
			address3.setPincode(69982412); 
			
			
			Customer customer1 = new Customer();
			Customer customer2 = new Customer();
			Customer customer3 = new Customer();
			
			customer1.setCustomerName("abeer");
			customer1.setCustomerEmail("abeer@gmail.com");
			customer1.setUsername("abeer100");
			customer1.setPassword("abeer@100");
			customer1.setAddress(address1);
			
			customer2.setCustomerName("abc");
			customer2.setCustomerEmail("abc102@gmail.com");
			customer2.setUsername("abc102");
			customer2.setPassword("abc@102");
			customer2.setAddress(address2);
			
			customer3.setCustomerName("saurabh");
			customer3.setCustomerEmail("saurabh@gmail.com");
			customer3.setUsername("saurabh.103");
			customer3.setPassword("saurabh@103");
			customer3.setAddress(address3);
			
			customerService.addCustomer(customer1);
			customerService.addCustomer(customer2);
			customerService.addCustomer(customer3);
			
			Order order1=new Order();
			Order order2=new Order();
			Order order3=new Order();
			
			order1.setQuantity(10);
			order1.setTransactionMode("Online");
			order1.setCustomer(customer1);
			order1.setPlanter(planter1);
			
			order2.setQuantity(20);
			order2.setTransactionMode("COD");
			order2.setCustomer(customer2);
			order2.setPlanter(planter2);
			
			order3.setQuantity(30);
			order3.setTransactionMode("Paytm");
			order3.setCustomer(customer3);
			order3.setPlanter(planter3);
			
			
			orderService.addOrder(order1);
			orderService.addOrder(order2);
			orderService.addOrder(order3);
		}

}
