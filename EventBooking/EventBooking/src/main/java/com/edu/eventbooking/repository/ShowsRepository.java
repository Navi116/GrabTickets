package com.edu.eventbooking.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.eventbooking.dao.Shows;
import com.edu.eventbooking.dao.Ticket;


@Repository
public interface ShowsRepository extends JpaRepository<Shows, Integer>{
	
	
	@Query(value = "select * from Shows where partner_pid=?", nativeQuery = true)
	Shows findshowbyPartner(Integer partnerid);
	
		
//	List<Shows> findByShownameAndShowdate(String showname, Date showdate);
//
	@Query(value = "select * from Shows where showname=?", nativeQuery = true)
	Shows findByShowname(String showName);

	

}
