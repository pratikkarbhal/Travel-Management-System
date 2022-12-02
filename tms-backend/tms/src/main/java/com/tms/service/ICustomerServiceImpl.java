package com.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.entities.Customer;
import com.tms.entities.User;
import com.tms.entities.Package;
import com.tms.repository.ICustomerRepository;
import com.tms.repository.IPackageRepository;
import com.tms.repository.IUserRepository;

@Service
@Transactional
public class ICustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;
	
	@Autowired
	private IPackageRepository packageRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	//Used for adding custmers
	@Override
	public Customer addCustomer(Customer customer) {
		Customer cust = customerRepository.save(customer);
		User user = new User();
		user.addCustomer(cust);
		userRepository.save(user);
		return cust;
	}
	
	//used for update customer
	@Override
	public Customer updateCustomer(Customer customer) {
		Customer cust = customerRepository.save(customer);
		return cust;
	}
	
	//used for delete customer
	@Override
	public Customer deleteCustomer(Integer customerId) {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.get();
		customerRepository.delete(customer);
		return customer;
	}
	
	//used for view customer by customer Id
	@Override
	public Customer viewCustomer(Integer customerId) {
		Optional<Customer> opt = customerRepository.findById(customerId);
		Customer cust = opt.get();
		return cust;
	}
	
	//used for viewing All customers 
	@Override
	public List<Customer> viewAllCustomers(int id) {
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}
	
	// Used for viewing all customers
	@Override
	public List<Customer> viewAll() {
		List<Customer> cust = customerRepository.findAll();
		return cust;
	}

	
	//Used for view customers by package Id
	@Override
	public Customer viewCustomerList(int id) {
		Optional<Package> opt = packageRepository.findById(id);
		Package pack = opt.get();
		int packId = customerRepository.findByPackage(pack);
		Optional<Customer> opt1 = customerRepository.findById(packId);
		Customer customer = opt1.get();
		return customer;
	}
}
	
	







