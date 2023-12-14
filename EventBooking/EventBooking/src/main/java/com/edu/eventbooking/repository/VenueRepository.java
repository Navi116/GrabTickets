package com.edu.eventbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edu.eventbooking.dao.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Integer> {

	@Query(value = "SELECT * FROM Venue WHERE venuename =? AND lower(street) LIKE lower(concat('%',?, '%'))", nativeQuery = true)
	 Venue findByVenueStreet( String venuename,  String street);

}
