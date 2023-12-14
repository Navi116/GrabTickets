package com.edu.eventbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.eventbooking.dao.Ticket;
import com.edu.eventbooking.repository.TicketRepository;

import jakarta.validation.Valid;
@Service
public class TicketServiceImplementation implements TicketService {
	@Autowired
	private TicketRepository ticketrepository;

	

	

}
