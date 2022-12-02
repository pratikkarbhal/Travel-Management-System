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
@Table(name = "HOTEL")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "HOTEL_ID")
	private int hotelId;
	
	@Column(name = "HOSTEL_NAME")
    private String hotelName;
	
	@Column(name = "HOTEL_TYPE")
    private String hotelType;
	
	@Column(name = "HOTEL_DESCRIPTION")
    private String hotelDescription;
	
	@Column(name = "ADDRESS")
    private String address;
	
	@Column(name = "RENT")
    private double rent;
	
	@Column(name = "STATUS")
    private String status;
	
	//Defining constructors
	public Hotel() {}

	public Hotel(int hotelId, String hotelName, String hotelType, String hotelDescription, String address, double rent,
			String status) {
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelType = hotelType;
		this.hotelDescription = hotelDescription;
		this.address = address;
		this.rent = rent;
		this.status = status;
	}
	
	// Getters and setters
	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelType() {
		return hotelType;
	}

	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}

	public String getHotelDescription() {
		return hotelDescription;
	}

	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	//ToString

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelType=" + hotelType
				+ ", hotelDescription=" + hotelDescription + ", address=" + address + ", rent=" + rent + ", status="
				+ status + "]";
	}
	
	
}
