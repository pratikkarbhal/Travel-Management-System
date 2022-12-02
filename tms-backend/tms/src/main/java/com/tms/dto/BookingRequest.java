package com.tms.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookingRequest {
	//BookingRequest

	@NotNull
	@Size(min = 2, max = 50)
	@NotBlank
	private String bookingType;
	@NotNull
	@Size(min = 2, max = 50)
	@NotBlank
	private String description;
	@NotNull
	@Size(min = 2, max = 50)
	@NotBlank
	private String bookingTitle;
	@NotNull
	private LocalDate bookingDate;
	private int userId;
	private int packageId;

	// Getters and Setters
	public String getBookingType() {
		return bookingType;
	}

	public String getDescription() {
		return description;
	}

	public String getBookingTitle() {
		return bookingTitle;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setBookingTitle(String bookingTitle) {
		this.bookingTitle = bookingTitle;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	private String bookingId;

	public String getBookingId() {
		return bookingId;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

}
