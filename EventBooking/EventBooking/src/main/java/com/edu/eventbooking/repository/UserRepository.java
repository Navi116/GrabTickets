package com.edu.eventbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.eventbooking.dao.User;

import jakarta.validation.Valid;



@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	@Query(value = "select * from User where mobilenumber like ?", nativeQuery = true)
	 User getDetailsByMobile(String mobilenumber);
	
	
	@Query(value = "select * from  User where email=?1 and password=?2", nativeQuery = true)
	User getUserByMailPass(@Valid String mail, String pass);

	@Query( value = "select * from User where email=?",nativeQuery = true)
	User findbyEmail(String email);


	

	

}
