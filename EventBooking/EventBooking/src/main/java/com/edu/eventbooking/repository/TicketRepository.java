package com.edu.eventbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.eventbooking.dao.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
	@Query(value = "select * from Ticket where bookingid=?",nativeQuery = true)
	Ticket findbyBookingId(String bookingid);

}
