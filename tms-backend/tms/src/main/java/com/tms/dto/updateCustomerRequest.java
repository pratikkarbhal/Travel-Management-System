package com.tms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class updateCustomerRequest {

	@NotBlank
	private String customerName;
	@NotBlank 
	private String customerPassword;
	@NotBlank
	private String address;
	@NotBlank @Size(min=10,max=11)
	private String mobileNo;
	@NotBlank
	private String email;
	
	// Getters and setters
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
		return "updateCustomerRequest [customerName=" + customerName + ", customerPassword=" + customerPassword
				+ ", address=" + address + ", mobileNo=" + mobileNo + ", email=" + email + "]";
	}
	
		
}
