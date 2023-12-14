package com.edu.eventbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.eventbooking.dao.Partner;
import com.edu.eventbooking.dao.Shows;
import com.edu.eventbooking.dao.Venue;
import com.edu.eventbooking.repository.PartnerRepository;
import com.edu.eventbooking.repository.ShowsRepository;
import com.edu.eventbooking.repository.VenueRepository;

@Service
public class VenueServiceImplementation implements VenueService {
	@Autowired
	private VenueRepository venueRepository;
	@Autowired
	private ShowsRepository showsRepository;
	@Autowired
	private PartnerRepository partnerrepository;

	@Override
	public Venue registerVenue(Venue venue) {
		return venueRepository.save(venue);
	}

	@Override
	public List<Venue> getAllVenues() {
		
		return venueRepository.findAll();
	}

	@Override
	public Venue setVenueToPartner(String pancard, String venue, String street) {
		Partner partner=partnerrepository.findbyPancard(pancard);
		Venue venueObj= venueRepository.findByVenueStreet(venue, street);
		venueObj.setPartner(partner);
		return venueRepository.save(venueObj);
	}

	

}
