package com.tms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERX")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;
	
	@Column(name = "USER_TYPE")
	private String userType;
	
	@Column(name = "PASSWORD")
	private String password;
	//mapping with customer
		@OneToOne
		@JoinColumn(name = "CUSTOMER_ID")
		private Customer customer;
	//mapping with Admin
		@OneToOne
		@JoinColumn(name = "ADMIN_ID")
		private Admin admin;
	
	//Defining Constructor
	public User() {}

	public User(int userId, String userType, String password) {
		this.userId = userId;
		this.userType = userType;
		this.password = password;
	}

	public User(String userType, String password) {
		super();
		this.userType = userType;
		this.password = password;
	}
	
	// Getters and setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userType=" + userType + ", password=" + password + "]";
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void addCustomer(Customer customer) {
		this.setUserId(customer.getCustomerId());
		this.setPassword(customer.getCustomerPassword());
		this.setUserType("customer");
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public void addAdmin(Admin admin) {
		this.setUserId(admin.getAdminId());
		this.setPassword(admin.getPassword());
		this.setUserType("admin");
	}
}
