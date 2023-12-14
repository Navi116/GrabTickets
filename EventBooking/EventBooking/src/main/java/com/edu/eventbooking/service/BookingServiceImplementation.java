package com.edu.eventbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.eventbooking.dao.Booking;
import com.edu.eventbooking.dao.Shows;
import com.edu.eventbooking.repository.BookingRepository;
import com.edu.eventbooking.repository.ShowsRepository;
@Service
public class BookingServiceImplementation implements BookingService {
	
	@Autowired
	private BookingRepository bookingrepository;
	private ShowsRepository showsRepository;
	
	@Override
	public Booking buyTicket(Booking book) {
//	the business logic for Tickets if the seat available
		
		return bookingrepository.save(book);
	}

}
