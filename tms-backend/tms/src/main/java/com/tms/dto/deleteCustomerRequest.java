package com.tms.dto;

import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.tms.entities.Feedback;

public class deleteCustomerRequest {

	@NotBlank
	private String customerName;
	@NotBlank
	private String customerPassword;
	@NotBlank
	private String address;
	@NotBlank
	@Size(min = 10, max = 11)
	private String mobileNo;
	@NotBlank
	private String email;
	private Set<Feedback> feedbacks;

	// Getters and Setters
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

}
