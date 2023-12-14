package com.edu.eventbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.eventbooking.dao.Shows;
import com.edu.eventbooking.repository.ShowsRepository;
import com.edu.eventbooking.service.ShowsService;

@RestController
public class ShowController {
	
	
	@Autowired
	private  ShowsService showsService;
	
	
	
	
	@PostMapping("/addShow{venue}/{address}")
	public Shows addShow(@RequestBody Shows show,@PathVariable("venue") String venue, @PathVariable("address") String address) {
		
		return showsService.addShow(show,venue,address);
	}
	
	
	@DeleteMapping("/deleteShow/{id}")
	public Shows deleteShow(@PathVariable("id") Integer id, Shows show ) {
		return showsService.deleteShow(id,show);
		
	}
	
	// this allows user to see the list of allshows with Theatre details
		@GetMapping("/getAllShows")
		public List<Shows> getAllShows() {
			return showsService.getAllShows();
			
		}
		
		@PutMapping("/setShowtoVenue/{show}/{venue}/{address}")
		public Shows setShowtoVenue(@PathVariable("show") String showname,@PathVariable("venue") String venue, @PathVariable("address") String address ) {
			
			return showsService.setVenuetoShow(showname,venue,address);
		}


}
