package com.tms.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tms.entities.Booking;
import com.tms.entities.Hotel;

public class PackageRequest {

	private int packageId;
	@NotNull
	@Size(min = 2, max = 50)
	private String packageName;
	@NotNull
	@Size(min = 2, max = 50)
	private String packageDescription;
	@NotNull
	@Size(min = 2, max = 50)
	private String packageType;
	@NotNull
	private double packageCost;

	private Booking booking;
	private Hotel hotel;

	// Getters and Setters
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

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	//toString
	@Override
	public String toString() {
		return "PackageRequest [packageId=" + packageId + ", packageName=" + packageName + ", packageDescription="
				+ packageDescription + ", packageType=" + packageType + ", packageCost=" + packageCost + ", booking="
				+ booking + ", hotel=" + hotel + "]";
	}

}
