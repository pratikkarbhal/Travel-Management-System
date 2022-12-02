package com.tms.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "CUSTOMER_ID")
	private Integer customerId;
	
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	
	@Column(name = "CUSTOMER_PASSWORD")
	private String customerPassword;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "MOBILE_NO")
	private String mobileNo;
	
	@Column(name = "EMAIL")
	private String email;
	//mapping with feedback
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private Feedback feedbacks;
	//mapping with user
	@OneToOne(mappedBy = "customer")
	private User user;
	
	public Customer() {}

	public Customer(Integer customerId, String customerName, String customerPassword, String address, String mobileNo,
			String email) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
	}
	

	public Customer(String customerName, String customerPassword, String address, String mobileNo, String email) {
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
	}
	
	// Getters and setters
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

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
	//ToString
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPassword="
				+ customerPassword + ", address=" + address + ", mobileNo=" + mobileNo + ", email=" + email + "]";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	public Feedback getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(Feedback feedbacks) {
		this.feedbacks = feedbacks;
	}

	public void addFeedback(Feedback feedback)
	{
		feedback.setCustomer(this);
		this.feedbacks=feedback;
	}
}
