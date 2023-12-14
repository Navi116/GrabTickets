package com.edu.eventbooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.eventbooking.dao.Shows;
import com.edu.eventbooking.dao.Venue;


public interface VenueService {

	Venue registerVenue(Venue venue);

	List<Venue> getAllVenues();

	Venue setVenueToPartner(String pancard, String venue, String street);

	}
