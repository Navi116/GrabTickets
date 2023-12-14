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
import com.edu.eventbooking.dao.Ticket;
import com.edu.eventbooking.dao.User;
import com.edu.eventbooking.repository.ShowsRepository;
import com.edu.eventbooking.repository.TicketRepository;
import com.edu.eventbooking.repository.UserRepository;
import com.edu.eventbooking.service.ShowsService;
import com.edu.eventbooking.service.TicketService;

import jakarta.validation.Valid;

@RestController
public class TicketController {

	@Autowired
	private TicketService ticketservice;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private ShowsRepository showsRepository;
	@Autowired
	private ShowsService showsService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/bookTicket")
	public ResponseEntity<Ticket> bookTicket(@Valid @RequestBody Ticket ticket) {
        Shows show=showsRepository.findByShowname(ticket.getShowname());
        if(show!=null && show.getAvailableseats()>=ticket.getSeats()) {
        	show.setAvailableseats(show.getAvailableseats()-ticket.getSeats());
        	Ticket newticket= ticketRepository.save(ticket);
        	 return new ResponseEntity<Ticket>(newticket,HttpStatus.CREATED);
        }
		
		 return ResponseEntity.badRequest().body(null); 
}
	
	
	@GetMapping("/bookinghistory")
	public ResponseEntity<List<Ticket>> bookinghistory(){
		if(ticketRepository.findAll()!=null) {
			List<Ticket> bookings=ticketRepository.findAll();
			return new ResponseEntity<List<Ticket>>(bookings,HttpStatus.OK);
		}
		
		return (ResponseEntity<List<Ticket>>) ResponseEntity.noContent();		
	}
	
	@PutMapping("/setTicketToUser/{bookingid}/{email}")
	public ResponseEntity<Ticket> setTicketToUser(@PathVariable("bookingid") String bookingid, @PathVariable("email") String email) {
		User bookeduser=userRepository.findbyEmail(email);
		Ticket bookedticket=ticketRepository.findbyBookingId(bookingid);
		if(bookeduser!=null && bookedticket!=null) {
			bookedticket.setUser(bookeduser);
			ticketRepository.save(bookedticket);
			return new ResponseEntity<Ticket>(bookedticket, HttpStatus.ACCEPTED);
		}
		return  ResponseEntity.badRequest().body(null);
	}
		
	
}
