package com.tms.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tms.dto.CustomerDetails;
import com.tms.dto.createCustomerRequest;
import com.tms.dto.deleteCustomerRequest;
import com.tms.dto.updateCustomerRequest;
import com.tms.entities.Customer;
import com.tms.entities.Feedback;
import com.tms.service.ICustomerService;
import com.tms.service.ICustomerServiceImpl;
import com.tms.util.CustomerUtil;

@RestController
@RequestMapping("/customer")
@Validated
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

	@Autowired
	private ICustomerService cService;

	@Autowired
	private CustomerUtil customerUtil;

	// For testing
	@RequestMapping("/hello")
	public String greet() {
		return "Hello!!";
	}

	// Used for adding customer
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public CustomerDetails addCustomer(@RequestBody @Valid createCustomerRequest requestData) {
		Customer newCustomer = new Customer(requestData.getCustomerName(), requestData.getCustomerPassword(),
				requestData.getAddress(), requestData.getMobileNo(), requestData.getEmail());
		Set<Feedback> feedbackSet = requestData.getFeedback();
		if (feedbackSet != null) {
			for (Feedback feed : feedbackSet) {
				newCustomer.addFeedback(feed);
			}
		}
		Customer newCust = cService.addCustomer(newCustomer);
		CustomerDetails customerDetails = customerUtil.toDetailsCustomer(newCust);
		return customerDetails;

	}

	// Used for updating customer
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/update/{id}")
	public CustomerDetails updateCustomer(@RequestBody @Valid updateCustomerRequest requestData,
			@PathVariable("id") @Min(1) int customerId){
		Customer customer = new Customer(requestData.getCustomerName(), requestData.getCustomerPassword(),
				requestData.getAddress(), requestData.getMobileNo(), requestData.getEmail());
		customer.setCustomerId(customerId);
		Customer cust = cService.updateCustomer(customer);
		CustomerDetails customerDetails = customerUtil.toDetailsCustomer(cust);
		return customerDetails;

	}

	// Used for deleting Customer
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public CustomerDetails deleteCustomer(@PathVariable("id") @Min(1) int customerId){
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		Customer cust = cService.deleteCustomer(customerId);
		CustomerDetails customerDetails = customerUtil.toDetailsCustomer(cust);
		return customerDetails;
	}

	// Used for viewing customer using customer ID
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public CustomerDetails viewCustomer(@PathVariable("id") @Min(1) int customerId){
		Customer cust = cService.viewCustomer(customerId);
		CustomerDetails customerDetails = customerUtil.toDetailsCustomer(cust);
		return customerDetails;
	}

	
	// Used for viewing all customers 
		@ResponseStatus(code = HttpStatus.OK)
		@GetMapping("/view/all")
		public List<Customer> viewAll()  {
			return cService.viewAll();
		}
		
	// Used to view all customers using package ID
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/pack/{id}")
	public CustomerDetails viewCustomersList(@PathVariable("id") int id){
		Customer cust = cService.viewCustomerList(id);
		CustomerDetails customerDetails = customerUtil.toDetailsCustomer(cust);
		return customerDetails;
	}


}
