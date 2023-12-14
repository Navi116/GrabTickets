package com.edu.eventbooking.service;

import java.util.List;


//import org.springframework.stereotype.Service;

import com.edu.eventbooking.dao.User;
import com.edu.eventbooking.error.GlobalException;




public interface UserService {

	public User registerUser(User user);

	public User editUsername(String mobile, String username) throws GlobalException;

	public List<User> getAllusers();

	public User updatePassword(String mobilenumber, String oldpass, String newpass) throws GlobalException;
	
	User updateUser(User user, Integer id);

	

}
