package com.edu.eventbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.eventbooking.dao.Shows;
import com.edu.eventbooking.dao.User;
import com.edu.eventbooking.dao.Venue;
import com.edu.eventbooking.repository.VenueRepository;
import com.edu.eventbooking.service.VenueService;

import jakarta.validation.Valid;

@RestController
public class VenueController {
	@Autowired
	private VenueRepository venueRepository;
	
	@Autowired
	private VenueService venueService;
	
	@PostMapping("/registerVenue")
	public ResponseEntity<Venue> registerVenue(@Valid @RequestBody Venue venue) {
		Venue checkVenue=venueRepository.findByVenueStreet(venue.getVenuename(),venue.getStreet());
		
			if(checkVenue!=null) {
				return new ResponseEntity<Venue>(HttpStatus.CONFLICT);
			}
			Venue newVenue=venueService.registerVenue(venue);
			return new ResponseEntity<Venue>(newVenue, HttpStatus.CREATED);
			
		}
	
	@GetMapping("/getAllVenues")
	public List<Venue> getAllVenues(){
		
		return venueService.getAllVenues();
	}
	
	@PutMapping("setVenueToPartner/{pancard}/{venue}/{street}")
	public Venue setVenueToPartner(@PathVariable("pancard") String pancard, @PathVariable("venue") String venue,@PathVariable("street") String street) {
		
		return venueService.setVenueToPartner(pancard, venue, street);
	}
	
	
	

	

}
