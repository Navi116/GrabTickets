package com.edu.eventbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.eventbooking.dao.Host;
import com.edu.eventbooking.dao.Shows;
import com.edu.eventbooking.dao.Ticket;
import com.edu.eventbooking.dao.Venue;
import com.edu.eventbooking.repository.HostRepository;
import com.edu.eventbooking.repository.ShowsRepository;
import com.edu.eventbooking.repository.VenueRepository;

import jakarta.validation.Valid;

@Service
public class ShowsServiceImplementation implements ShowsService {
	
	@Autowired
	private ShowsRepository showsRepository;
	

	@Autowired
	private HostRepository hostRepository;
	
	@Autowired
	private VenueRepository venueRepository;
	

	@Override
	public Shows addShow(Shows show) {
		
		return showsRepository.save(show) ;
	}

	@Override
	public Shows registerEvent(Shows show) {
		// TODO Auto-generated method stub
		return showsRepository.save(show);
	}



	@Override
	public Shows deleteShow(Integer id, Shows show) {
	Shows s=showsRepository.findById(id).get();
	showsRepository.delete(s);
	return s;  
	}

	@Override
	public List<Shows> getAllShows() {
		
		return showsRepository.findAll();
	}

	

	@Override
	public Shows updateShowName(String showname, Integer partnerid) {
		Shows show=showsRepository.findshowbyPartner(partnerid);
		show.setShowname(showname);
		return showsRepository.save(show);
	}

	@Override
	public Shows setShowToHost(Integer hostid, Integer showid) {
		Host host=hostRepository.findById(hostid).get();
		Shows show=showsRepository.findById(showid).get();
		show.setHost(host);
		return showsRepository.save(show);
	}

	@Override
	public Shows setVenuetoShow(String showname, String theatre, String address) {
		Shows show=showsRepository.findByShowname(showname);
		System.out.println(show);
		Venue venueid= venueRepository.findByVenueStreet(theatre,address);
		System.out.println(venueid);
		show.setVenue(venueid);
		return showsRepository.save(show);
	}

	@Override
	public Shows addShow(Shows show, String venue, String address) {
	Shows newshow=showsRepository.save(show);
	newshow.setVenue(venueRepository.findByVenueStreet(venue, address));
	return showsRepository.save(newshow);
	}

	
	
	
	
			
	


	
	

}
