package com.cg.onlineplantnursery.customer.service;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlineplantnursery.customer.repository.IAddressRepository;
import com.cg.onlineplantnursery.customer.repository.ICustomerRepository;
import com.cg.onlineplantnursery.customer.entity.Address;
import com.cg.onlineplantnursery.customer.entity.Customer;

import com.cg.onlineplantnursery.exceptions.*;


@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerRepository repository;
	
	@Autowired
	private IAddressRepository addressRepository;
	
	// For adding a Customer object 
    @Transactional
	@Override
	public Customer addCustomer(Customer customer){
		
		validateCustomer(customer);
		addressRepository.save(customer.getAddress());
		Customer saved = repository.save(customer);
		return saved;
		
	}
    
    // For updating a Customer object
	@Transactional
	@Override
	public Customer updateCustomer(Customer tenant) {
		Integer id= tenant.getCustomerId();
		boolean exists = repository.existsById(id);
		if (!exists) {
			throw new CustomerNotFoundException("Customer not found");
		}
		
		addressRepository.save(tenant.getAddress());
		
		return repository.save(tenant);
	}
	
	// For deleting a Customer object
	@Transactional	
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
	
	// To view a customer object by Id
	@Transactional
	@Override
	   public Customer viewCustomer(int customerId){
		   validateCustomerId(customerId);
		   Optional<Customer> optional = repository.findById(customerId);
		   if(!optional.isPresent()) {
			   throw new CustomerNotAddedException("No Customer passed");
		   }
		   return optional.get();
		   }
	
	// To view all customer objects
	@Transactional
	@Override
	public List<Customer> viewAllCustomers(){
		List<Customer> customerList= repository.findAll();
		if(customerList.isEmpty()) {
			throw new CustomerNotFoundException("customers not found");
		}
		return customerList;
	}
	
	// to validate if a Customer object is null or its name, email or password is empty
	public void validateCustomer(Customer customer) {
		if(customer == null ) {
			throw new CustomerNotAddedException("No Customer passed");
		}
		if(customer.getCustomerName()=="") {
			throw new InvalidCustomerNameException("Name cannot be empty");
		}
		if(customer.getCustomerEmail()=="") {
			throw new InvalidCustomerEmailException("Email cannot be empty");
		}
		if(customer.getPassword()=="") {
			throw new InvalidCustomerPasswordException("Password cannot be empty");
		}
	}
	
	// to validate if a Customer id is valid or not
	public void validateCustomerId(int id) {
		if(id<0) {
			throw new InvalidCustomerIdException("Invalid Customer ID passed");
		}
	}

}