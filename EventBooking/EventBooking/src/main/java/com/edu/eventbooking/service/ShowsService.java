package com.edu.eventbooking.service;

import java.util.List;


//import com.edu.eventbooking.dao.Partner;
import com.edu.eventbooking.dao.Shows;
//import com.edu.eventbooking.dao.Ticket;
//import com.edu.eventbooking.dao.User;
//import com.edu.eventbooking.error.GlobalException;
//
//import jakarta.validation.Valid;



public interface ShowsService {

	Shows addShow(Shows show);

	Shows registerEvent(Shows show);

	
	Shows deleteShow(Integer id, Shows show);

	List<Shows> getAllShows();

	Shows updateShowName(String showname, Integer partnerid);

	Shows setShowToHost(Integer hostid, Integer showid);

	Shows setVenuetoShow(String showname, String theatre, String address);

	Shows addShow(Shows show, String venue, String address);

	
	
	
//	void deleteShowByIdAndName(Integer showid, String showname) throws GlobalException;
//
//
//
//	Shows updateShowDetailsById(Integer showId, Shows updatedShow) throws GlobalException;
//
//
//
//	boolean doesShowExist(Integer showId);

}
