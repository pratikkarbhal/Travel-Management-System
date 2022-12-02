package com.tms.entities;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "BOOKING")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOKING_ID")
	private int bookingId;
	
	@Column(name = "BOOKING_TYPE")
    private String bookingType;
	
	@Column(name = "DESCRIPTION")
    private String description;
	
	@Column(name = "BOOKING_TITLE")
    private String bookingTitle;
	
	@Column(name = "BOOKING_DATE")
    private LocalDate bookingDate;
	
	//mapping with package
	@OneToOne
	@JoinColumn(name = "PACK")
    private Package pack;
	
	@Column(name = "PACK_ID")
	private int packId;
	
	@Column(name = "USER_ID")
    private int userId;

	//Defining constructor
	public Booking() {}
	
	public Booking(int bookingId, String bookingType, String description, String bookingTitle, LocalDate bookingDate,
			Package pack, int userId) {
		this.bookingId = bookingId;
		this.bookingType = bookingType;
		this.description = description;
		this.bookingTitle = bookingTitle;
		this.bookingDate = bookingDate;
		this.pack = pack;
		this.userId = userId;
	}

	
	public Booking(String bookingType, String description, String bookingTitle, LocalDate bookingDate, int userId) {
		super();
		this.bookingType = bookingType;
		this.description = description;
		this.bookingTitle = bookingTitle;
		this.bookingDate = bookingDate;
		this.userId = userId;
	}
	
	 //Generating Getters and Setters
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingType() {
		return bookingType;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBookingTitle() {
		return bookingTitle;
	}

	public void setBookingTitle(String bookingTitle) {
		this.bookingTitle = bookingTitle;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Package getPack() {
		return pack;
	}

	public void setPack(Package pack) {
		this.pack = pack;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getPackId() {
		return packId;
	}

	public void setPackId(int packId) {
		this.packId = packId;
	}
	//TOString
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingType=" + bookingType + ", description=" + description
				+ ", bookingTitle=" + bookingTitle + ", bookingDate=" + bookingDate + ", pack=" + pack + ", userId="
				+ userId + "]";
	}

}
