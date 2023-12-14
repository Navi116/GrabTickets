package com.edu.eventbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.eventbooking.dao.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer>{
//	@Query(value = "select * from Partner where pancard like ?",nativeQuery = true)
//	List<Partner> findbyPancard(String pancard);
//	
	@Query(value = "select * from Partner where pancard like ?",nativeQuery = true)
	Partner findbyPancard(String pancard);
	
	@Query(value = "select * from Partner where email=?1 and password=?2", nativeQuery = true)
	Partner findByEmailPass(String email, String pass);


	
	

}
