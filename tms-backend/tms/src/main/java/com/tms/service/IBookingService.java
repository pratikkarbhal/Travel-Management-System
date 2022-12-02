package com.tms.service;

import java.util.List;

import com.tms.entities.Booking;

public interface IBookingService {
	
	public Booking makeBooking(Booking booking);
	public Booking cancelBooking(int bookingId);
	public Booking viewBooking(int bookingId);
	public List<Booking> viewAllBookings();

}
