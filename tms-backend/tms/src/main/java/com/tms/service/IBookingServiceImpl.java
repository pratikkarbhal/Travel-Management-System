package com.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.entities.Booking;
import com.tms.entities.Package;

import com.tms.repository.IBookingRepository;
import com.tms.repository.IPackageRepository;

@Service
@Transactional
public class IBookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingRepository bookingRepository;
	
	@Autowired
	private IPackageRepository packageRepository;

	//used for make bookings
	@Override
	public Booking makeBooking(Booking booking) {
		Booking book = bookingRepository.save(booking);
		return book;
	}

	//used for cancel booking using booking Id
	@Override
	public Booking cancelBooking(int bookingId)  {
		Booking book = viewBooking(bookingId);
		bookingRepository.delete(book);
		return book;
	}
	//used for view booking using booking Id
	@Override
	public Booking viewBooking(int bookingId)  {
		Optional<Booking> optional = bookingRepository.findById(bookingId);
		Booking book = optional.get();
		return book;
	}
	//used for view All Bookings
	@Override
	public List<Booking> viewAllBookings() {
		List<Booking> bookings = bookingRepository.findAll();
		return bookings;
	}

}
