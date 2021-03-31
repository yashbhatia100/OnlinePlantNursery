package com.cg.onlineplantnursery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.customer.entity.Address;
import com.cg.onlineplantnursery.customer.entity.Customer;
import com.cg.onlineplantnursery.customer.service.ICustomerService;
import com.cg.onlineplantnursery.dto.AddCustomerRequest;
import com.cg.onlineplantnursery.dto.ChangeCustomerAddressRequest;
import com.cg.onlineplantnursery.dto.ChangeCustomerEmailRequest;
import com.cg.onlineplantnursery.dto.ChangeCustomerNameRequest;
import com.cg.onlineplantnursery.dto.ChangeCustomerPasswordRequest;
import com.cg.onlineplantnursery.dto.CustomerDetails;
import com.cg.onlineplantnursery.dto.DeleteCustomerRequest;
import com.cg.onlineplantnursery.util.CustomerUtil;

@RequestMapping("/customer")
@RestController
public class CustomerRestController {

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private CustomerUtil util;

	@GetMapping(value = "/fetch/byid/{id}")
	public CustomerDetails fetchCustomerDetails(@PathVariable("id") Integer customerId) {
		Customer customer = customerService.viewCustomer(customerId);
		CustomerDetails details = util.toDetails(customer);
		return details;

	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public CustomerDetails addCustomer(@RequestBody AddCustomerRequest requestData) {
		Address address = new Address();

		address.setHouseNo(requestData.getHouseNo());
		address.setCity(requestData.getCity());
		address.setState(requestData.getState());
		address.setColony(requestData.getColony());
		address.setPincode(requestData.getPincode());

		Customer customer = new Customer();
		customer.setCustomerName(requestData.getCustomerName());
		customer.setCustomerEmail(requestData.getCustomerEmail());
		customer.setUsername(requestData.getUsername());
		customer.setPassword(requestData.getPassword());
		customer.setAddress(address);

		customerService.addCustomer(customer);

		CustomerDetails details = util.toDetails(customer);
		return details;

	}

	@PutMapping("/changename")
	public CustomerDetails changeCustomerName(@RequestBody ChangeCustomerNameRequest requestData) {
		Integer customerId = requestData.getId();
		Customer customer = customerService.viewCustomer(customerId);
		customer.setCustomerName(requestData.getCustomerName());
		customerService.updateCustomer(customer);
		CustomerDetails details = util.toDetails(customer);
		return details;

	}

	@PutMapping("/changeemail")
	public CustomerDetails changeCustomerEmail(@RequestBody ChangeCustomerEmailRequest requestData) {
		Integer id = requestData.getId();
		Customer customer = customerService.viewCustomer(id);
		customer.setCustomerEmail(requestData.getCustomerEmail());
		customerService.updateCustomer(customer);
		CustomerDetails details = util.toDetails(customer);
		return details;
	}

	@PutMapping("/changepassword")
	public CustomerDetails changeCustomerPassword(@RequestBody ChangeCustomerPasswordRequest requestData) {
		Integer id = requestData.getCustomerId();
		Customer customer = customerService.viewCustomer(id);
		customer.setPassword(requestData.getPassword());
		customerService.updateCustomer(customer);
		CustomerDetails details = util.toDetails(customer);
		return details;
	}

	@PutMapping("/changeaddress")
	public CustomerDetails changeCustomerAddress(@RequestBody ChangeCustomerAddressRequest requestData) {
		Integer id = requestData.getCustomerId();
		Customer customer = customerService.viewCustomer(id);
		customer.getAddress().setHouseNo(requestData.getHouseNo());
		customer.getAddress().setColony(requestData.getColony());
		customer.getAddress().setCity(requestData.getCity());
		customer.getAddress().setState(requestData.getState());
		customer.getAddress().setPincode(requestData.getPincode());
		customerService.updateCustomer(customer);
		CustomerDetails details = util.toDetails(customer);
		return details;

	}

	@ResponseStatus(HttpStatus.GONE)
	@DeleteMapping("/delete")
	public String deleteCustomer(@RequestBody DeleteCustomerRequest requestData) {
		Integer id = requestData.getId();
		Customer customer = customerService.viewCustomer(id);
		customerService.deleteCustomer(customer);
		return "Customer with id" + id + " is deleted";
	}

	@GetMapping("/fetch")
	public List<CustomerDetails> allCustomerDetails() {

		List<Customer> list = customerService.viewAllCustomers();
		List<CustomerDetails> details = util.toDetailList(list);
		return details;

	}

}
