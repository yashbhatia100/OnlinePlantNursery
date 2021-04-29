package com.cg.onlineplantnursery.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlineplantnursery.customer.entity.Customer;
import com.cg.onlineplantnursery.customer.repository.IAddressRepository;
import com.cg.onlineplantnursery.customer.repository.ICustomerRepository;
import com.cg.onlineplantnursery.exceptions.CustomerNotAddedException;
import com.cg.onlineplantnursery.exceptions.CustomerNotFoundException;
import com.cg.onlineplantnursery.exceptions.InvalidCustomerEmailException;
import com.cg.onlineplantnursery.exceptions.InvalidCustomerIdException;
import com.cg.onlineplantnursery.exceptions.InvalidCustomerNameException;
import com.cg.onlineplantnursery.exceptions.InvalidCustomerPasswordException;
import org.slf4j.*;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	private static final Logger Log=LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private ICustomerRepository repository;

	@Autowired
	private IAddressRepository addressRepository;

	// For adding a Customer object
	@Transactional
	@Override
	public Customer addCustomer(Customer customer) {
		Log.debug("inside add Customer");

		validateCustomer(customer);
		addressRepository.save(customer.getAddress());
		Customer saved = repository.save(customer);
		return saved;

	}

	// For updating a Customer object
	@Transactional
	@Override
	public Customer updateCustomer(Customer tenant) {
		Log.debug("inside update Customer");
		Integer id = tenant.getCustomerId();
		boolean exists = repository.existsById(id);
		if (!exists) {
			throw new CustomerNotFoundException("Customer not found for update request");
		}

		addressRepository.save(tenant.getAddress());

		return repository.save(tenant);
	}

	// For deleting a Customer object
	@Transactional
	@Override
	public Customer deleteCustomer(Customer tenant) {
		Log.debug("inside delete Customer");
		Integer id = tenant.getCustomerId();
		boolean exists = repository.existsById(id);
		if (!exists) {
			throw new CustomerNotAddedException("No Customer passed for delete request");
		}
		repository.deleteById(id);
		return null;

	}

	// To view a customer object by Id
	@Transactional
	@Override
	public Customer viewCustomer(int customerId) {
		Log.debug("inside view  Customer with "+customerId);
		validateCustomerId(customerId);
		Optional<Customer> optional = repository.findById(customerId);
		if (!optional.isPresent()) {
			throw new CustomerNotAddedException("No Customer passed for view request");
		}
		return optional.get();
	}

	// To view all customer objects
	@Transactional
	@Override
	public List<Customer> viewAllCustomers() {
		Log.debug("inside view All Customer");
		List<Customer> customerList = repository.findAll();
		if (customerList.isEmpty()) {
			throw new CustomerNotFoundException("customers not found");
		}
		return customerList;
	}

	// to validate if a Customer object is null or its name, email or password is
	// empty
	public void validateCustomer(Customer customer) {
		if (customer == null) {
			throw new CustomerNotAddedException("No Customer passed");
		}
		if (customer.getCustomerName().equals("")) {
			throw new InvalidCustomerNameException("Name cannot be empty");
		}
		if (customer.getCustomerEmail().equals("")) {
			throw new InvalidCustomerEmailException("Email cannot be empty");
		}
		if (customer.getPassword().equals("")) {
			throw new InvalidCustomerPasswordException("Password cannot be empty");
		}
	}

	// to validate if a Customer id is valid or not
	public void validateCustomerId(int id) {
		if (id < 0) {
			throw new InvalidCustomerIdException("Invalid Customer ID passed");
		}
	}

}