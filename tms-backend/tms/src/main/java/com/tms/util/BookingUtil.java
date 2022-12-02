package com.tms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tms.dto.BookingDetails;
import com.tms.entities.Booking;

@Component
public class BookingUtil {

	public BookingDetails toDetailsBooking(Booking book)
	{
		BookingDetails bookingDetails = new BookingDetails(book.getBookingId(),book.getBookingType(),book.getDescription(),book.getBookingTitle(),book.getBookingDate());
		bookingDetails.setPackageId(book.getPackId());
		bookingDetails.setUserId(book.getUserId());
		return bookingDetails;
	}
	
	public List<BookingDetails> toDetailsBooking(Collection<Booking> book)
	{
		List<BookingDetails> bookingList = new ArrayList<>();
		for (Booking boo : book) {
			BookingDetails bookingDetails = toDetailsBooking(boo);
			bookingList.add(bookingDetails);
		}
		return bookingList;
	}
}
