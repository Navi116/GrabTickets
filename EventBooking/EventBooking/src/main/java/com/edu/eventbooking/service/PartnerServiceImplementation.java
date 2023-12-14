package com.edu.eventbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.eventbooking.dao.Partner;
import com.edu.eventbooking.error.GlobalException;
import com.edu.eventbooking.repository.PartnerRepository;

@Service
public class PartnerServiceImplementation implements PartnerService {

	@Autowired
	private PartnerRepository partnerRepository;


	@Override
	public List<Partner> getAllPartners() throws GlobalException {
		List<Partner> list=partnerRepository.findAll();
		if( list.isEmpty()) {
			throw new GlobalException("There are no partners");
		}
		
		return partnerRepository.findAll();
	}




	//@Override
	//public Partner registerPartner(Partner partner) {
	//	
//		return partnerRepository.save(partner);
	//}




	@Override
	public Partner findbyPancard(String pancard) throws GlobalException {
		Partner partner= partnerRepository.findbyPancard(pancard);
		if(partner!=null) {
			return partner;
		}
		else {
			throw new GlobalException("No user found ");
		}
		
	}



	@Override
	public Partner registerPartner(Partner partner) throws GlobalException {
	Partner p= partnerRepository.findbyPancard(partner.getPancard());
	if(p !=null) {
		throw new GlobalException("User already exists on this pancard");
	}		
	return partnerRepository.save(partner);

		}






	@Override
	public String deletePartnerById(Integer id) throws GlobalException {
		Optional<Partner> p=partnerRepository.findById(id);
		if(p.isPresent()) {
			partnerRepository.deleteById(id);
			return "Employee of id "+id+" deleted";
		}
		throw new GlobalException("No partner found with id"+id);
	}





		



}
