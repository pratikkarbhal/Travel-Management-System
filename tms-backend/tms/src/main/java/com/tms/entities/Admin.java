package com.tms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADMIN_ID")
	private int adminId;
	
	@Column(name = "ADMIN_NAME")
    private String adminName;
	
	@Column(name = "PASSWORD")
    private String password;
	
	@Column(name = "EMAIL")
    private String email;
	
	@Column(name = "MOBILE")
    private String mobile;
	
	//Mapping with user
	@OneToOne(mappedBy = "admin")
	private User user;
	
	public Admin() {}
	
    public Admin(int adminId, String adminName, String password, String email, String mobile) {
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}
    
    //Generating Getters and Setters
    
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		}
	
	//ToString
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", password=" + password + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}
    
	
}
