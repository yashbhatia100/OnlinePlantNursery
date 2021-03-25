package com.cg.onlineplantnursery.customer.service;

import java.util.Optional;
import java.util.List;
import com.cg.onlineplantnursery.customer.repository.*;
import com.cg.onlineplantnursery.customer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlineplantnursery.exceptions.CustomerNotAddedException;
import com.cg.onlineplantnursery.exceptions.CustomerNotFoundException;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerRepository repository;
	

	@Override
	public Customer addCustomer(Customer customer){
		
		if(customer == null ) {
			throw new CustomerNotAddedException("No Customer passed");
		}
		Customer saved = repository.save(customer);
		return saved;
		
	}
	
	@Override
	public Customer updateCustomer(Customer tenant) {
		Integer id= tenant.getCustomerId();
		boolean exists = repository.existsById(id);
		if (!exists) {
			throw new CustomerNotFoundException("Customer not found");
		}
		return repository.save(tenant);
	}
	
		
	@Override
	   public  Customer deleteCustomer(Customer tenant) {
		   Integer id = tenant.getCustomerId();
		   boolean exists = repository.existsById(id);
		   if(!exists) {
			   throw new CustomerNotAddedException("No Customer passed");
			}
			 repository.deleteById(id);
			 return null;
			   
		   }
	
	@Override
	   public Customer viewCustomer(int customerId){
		   Optional<Customer> optional = repository.findById(customerId);
		   if(!optional.isPresent()) {
			   throw new CustomerNotAddedException("No Customer passed");
		   }
		   return optional.get();
		   }
	
	@Override
	public List<Customer> viewAllCustomers(){
		List<Customer> customerList= repository.findAll();
		if(customerList.isEmpty()) {
			throw new CustomerNotFoundException("customers not found");
		}
		return customerList;
	}


	

	
	

	
}
