package com.edu.eventbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.eventbooking.dao.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
	

}
