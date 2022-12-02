package com.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.tms.dto.CustomerDetails;
import com.tms.entities.Customer;
import com.tms.entities.Feedback;

@Component
public class CustomerUtil {

	public CustomerDetails toDetailsCustomer(Customer customer) {
		CustomerDetails cust = new CustomerDetails(customer.getCustomerId(), customer.getCustomerName(),
				customer.getCustomerPassword(), customer.getAddress(), customer.getMobileNo(), customer.getEmail());
		return cust;

	}

	public List<CustomerDetails> toDetailsCustomer(Collection<Customer> customers) {
		List<CustomerDetails> customerList = new ArrayList<>();
		for (Customer cust : customers) {
			CustomerDetails customerDetail = toDetailsCustomer(cust);
			customerList.add(customerDetail);
		}
		return customerList;
	}
	
}