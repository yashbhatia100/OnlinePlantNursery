package com.cg.onlineplantnursery.customer.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

import com.cg.onlineplantnursery.customer.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Integer>
{
	Customer addCustomer(Customer customer);

	Customer updateCustomer(Customer tenant);

	Customer deleteCustomer(Customer tenant);

	Customer viewCustomer(int customerId);
	

	List<Customer> viewAllCustomers();

	boolean validateCustomer(String userName, String password);
	
	/*Customer delete(Customer tenant);
	Customer save(Customer customer);
	boolean existsById(Integer id);
	List<Customer> findAll();
	Optional<Customer> findById(Integer id);*/
}
