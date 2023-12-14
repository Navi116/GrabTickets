package com.edu.eventbooking.service;

import java.util.List;
import com.edu.eventbooking.dao.Partner;
import com.edu.eventbooking.error.GlobalException;

public interface PartnerService {

	Partner registerPartner(Partner partner) throws GlobalException;

	List<Partner> getAllPartners() throws GlobalException;

	Partner findbyPancard(String pancard) throws GlobalException;

	String deletePartnerById(Integer id) throws GlobalException;

	
}
