package com.edu.eventbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.eventbooking.dao.Partner;
import com.edu.eventbooking.error.GlobalException;
import com.edu.eventbooking.repository.PartnerRepository;
import com.edu.eventbooking.service.PartnerService;



@RestController
public class PartnerController {
	//injecting the respective service classes and interfaces
	@Autowired
	private PartnerService partnerService;
	
	@Autowired
	private PartnerRepository partnerRepository;
	
	
	 
	
	//method to register as partner
	@PostMapping("/registerPartner")
	public ResponseEntity<Partner>  registerPartner( @RequestBody Partner partner) throws GlobalException{
		Partner p=partnerRepository.findbyPancard(partner.getPancard());
		if(p!=null) {
			return ResponseEntity.badRequest().body(null);
		}else {
			
			Partner newpartner = partnerService.registerPartner(partner);
			return new ResponseEntity<Partner>(newpartner, HttpStatus.CREATED);
		}
		
	}
	
	
	//method to retrieve all partners
	@GetMapping("/getAllPartners")
	public List<Partner> getAllPartners() throws GlobalException {
		
		return partnerService.getAllPartners();
		
	}
	
	//delete parnter by id
	@DeleteMapping("/deletePartnerById/{id}")
	public String deletePartnerById(@PathVariable("id") Integer id ) throws GlobalException {
		
		return partnerService.deletePartnerById(id);
	}
	
	
	//method to get details by pancard
	@GetMapping("/findbyPancard/{pan}")
	public Partner findbyPancard(@PathVariable("pan") String pancard) throws GlobalException {
		
		return partnerService.findbyPancard(pancard);
	}
	
	@GetMapping("/findByEmailPass/{email}/{pass}")
	public ResponseEntity<Partner> findByEmailPass(@PathVariable("email") String email, @PathVariable("pass") String pass) {
		Partner partner = partnerRepository.findByEmailPass(email,pass);
		
		if(partner != null) {
			return new ResponseEntity<Partner>(partner,HttpStatus.ACCEPTED);
		}
		
		return ResponseEntity.badRequest().body(null);
		
	}
	
}
