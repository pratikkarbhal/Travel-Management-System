package com.tms.service;

import java.util.List;

import com.tms.entities.Customer;

public interface ICustomerService {

	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer deleteCustomer(Integer customerId);
	public Customer viewCustomer(Integer customerid);
	public List<Customer> viewAllCustomers(int packageId);
	public Customer viewCustomerList(int routeId);
	List<Customer> viewAll();
	
}
