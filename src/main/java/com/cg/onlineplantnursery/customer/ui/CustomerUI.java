package com.cg.onlineplantnursery.customer.ui;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlineplantnursery.customer.entity.Customer;
import com.cg.onlineplantnursery.customer.repository.ICustomerRepository;
import com.cg.onlineplantnursery.customer.service.ICustomerService;

@Component
public class CustomerUI {
	
	
	@Autowired
	ICustomerService customerService;
	
	@Autowired
	ICustomerRepository customerRepository;
	
	public void start(){
		System.out.println("adding Customer");
		
		Customer customer1 = new Customer();
		Customer customer2 = new Customer();
		Customer customer3 = new Customer();
		
		
		customer1.setCustomerName("abeer");
		customer1.setCustomerEmail("abeer@gmail.com");
		customer1.setUsername("abeer100");
		customer1.setPassword("abeer@100");
		
		
	
		customer2.setCustomerName("abc");
		customer2.setCustomerEmail("abc102@gmail.com");
		customer2.setUsername("abc102");
		customer2.setPassword("abc@102");
		
	
		customer3.setCustomerName("saurabh");
		customer3.setCustomerEmail("saurabh@gmail.com");
		customer3.setUsername("saurabh.103");
		customer3.setPassword("saurabh@103");
		
		
		customerService.addCustomer(customer1);
		customerService.addCustomer(customer2);
		customerService.addCustomer(customer3);
		
		System.out.println("\n********************* Saved Customers in database *********************\n");
		display(customer1);
		display(customer2);
		display(customer3);
		
		customer1.setCustomerName("wolf");
		customer2.setPassword("haha");
		
		customerService.updateCustomer(customer1);
		customerService.updateCustomer(customer2);
		
		Customer fetchedCustomer1= customerService.viewCustomer(customer1.getCustomerId());
		Customer fetchedCustomer2= customerService.viewCustomer(customer2.getCustomerId());
		
		System.out.println("\n********************* Updated Customers in database *********************\n");
		
		customerService.deleteCustomer(fetchedCustomer1);
		
		System.out.println("\n********************* deleted a customer *********************\n");
		
		List<Customer> listOfCustomers = customerService.viewAllCustomers();
		
		for(Customer customer:listOfCustomers) {
			display(customer);
		}
	}
public void display(Customer customer) {
	System.out.println("CustomerId: "+customer.getCustomerId()+"\ncustomer name: "+customer.getCustomerName()
	+"\nCustomer Email: "+customer.getCustomerEmail()+"\nCustomer Username: "+customer.getUsername()
	+"\nCustomer Password: "+customer.getPassword()
	);
}
}

















/*package com.cg.onlineplantnursery.customer.ui;

import com.cg.onlineplantnursery.customer.entity.*;
import com.cg.onlineplantnursery.customer.service.ICustomerService;
import com.cg.onlineplantnursery.customer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerUI {
	@Autowired
	ICustomerService service;
	
	@Autowired
	ICustomerRepository repository;
	
	public void start() {
		
		Customer customer1=new Customer(); 
		Customer customer2=new Customer(); 
		
		/*customer1.setCustomerName("Abeer");
		customer1.setCustomerEmail("Abeer@gmail.com");
		customer1.setUsername("Abeer123");
		customer1.setPassword("flower");
		
		customer2.setCustomerName("Aahil");
		customer2.setCustomerEmail("aahil@gmail.com");
		customer2.setUsername("Aahil123");
		customer2.setPassword("blahblah");
		
		
		service.addCustomer(customer1);
		service.addCustomer(customer2);
		
		System.out.println("customer by id");
		Customer fetchedCustomer=service.viewCustomer(customer1.getCustomerId());
		System.out.println("display fetched customer"+ customer1.getCustomerId());
		display(fetchedCustomer);
		
		
	}
	
	public void display(Customer customer) {
		System.out.println("customer" +customer.getCustomerId());
	}

}*/
