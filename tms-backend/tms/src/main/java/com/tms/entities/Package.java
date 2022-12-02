package com.tms.entities;

import javax.persistence.*;

@Entity
@Table(name = "PACKAGE")
public class Package {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PACKAGE_ID")
	private int packageId;
	
	@Column(name = "PACKAGE_NAME")
    private String packageName;
	
	@Column(name = "PACKAGE_DESCRIPTION")
    private String packageDescription;
	
	@Column(name = "PACKAGE_TYPE")
    private String packageType;
	
	@Column(name = "PACKAGE_COST")
    private double packageCost;
	//mapping with payment
	@OneToOne(cascade = CascadeType.ALL)
    private PaymentDetails payment;
	//mapping with ticket
	@OneToOne(cascade = CascadeType.ALL)
    private TicketDetails ticket;
	//mapping with hotel
	@OneToOne(cascade = CascadeType.ALL)
    private Hotel hotel;
	
	//Defining constructor
	public Package() {}

	public Package(int packageId, String packageName, String packageDescription, String packageType, double packageCost,
			PaymentDetails payment, TicketDetails ticket, Hotel hotel) {
		this.packageId = packageId;
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.packageType = packageType;
		this.packageCost = packageCost;
		this.payment = payment;
		this.ticket = ticket;
		this.hotel = hotel;
	}

	// Getters and setters
	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public double getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}

	public PaymentDetails getPayment() {
		return payment;
	}

	public void setPayment(PaymentDetails payment) {
		this.payment = payment;
	}

	public TicketDetails getTicket() {
		return ticket;
	}

	public void setTicket(TicketDetails ticket) {
		this.ticket = ticket;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Package [packageId=" + packageId + ", packageName=" + packageName + ", packageDescription="
				+ packageDescription + ", packageType=" + packageType + ", packageCost=" + packageCost + ", hotel="
				+ hotel + "]";
	}
	
	
	
}
