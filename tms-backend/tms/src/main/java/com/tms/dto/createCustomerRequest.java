package com.tms.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.tms.entities.Feedback;

public class createCustomerRequest {
//Create Customer Request
	@NotBlank
	@Size(min = 2, max = 20)
	private String customerName;
	@NotBlank
	@Size(min = 2, max = 20)
	private String customerPassword;
	@NotBlank
	private String address;
	@NotBlank @Size(min=10,max=11)
	private String mobileNo;
	@NotBlank 
	private String email;
	private Set<Feedback> feedback;
	private int customerId;

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

	public Set<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedbacks(Set<Feedback> feedback) {
		this.feedback = feedback;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	// Default Constructor
	public createCustomerRequest() {
	}

	// toString
	@Override
	public String toString() {
		return "createCustomerRequest [customerName=" + customerName + ", customerPassword=" + customerPassword
				+ ", address=" + address + ", mobileNo=" + mobileNo + ", email=" + email + ", feedbacks=" + feedback
				+ "]";
	}
}
