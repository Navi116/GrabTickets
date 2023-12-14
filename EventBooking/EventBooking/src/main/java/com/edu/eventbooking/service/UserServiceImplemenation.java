package com.edu.eventbooking.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.eventbooking.dao.User;
import com.edu.eventbooking.error.GlobalException;
import com.edu.eventbooking.repository.UserRepository;

@Service
public class UserServiceImplemenation implements UserService {
	@Autowired
	private UserRepository userRepository;


	@Override
	public User editUsername(String mobile, String username) throws GlobalException {
		User u1=userRepository.getDetailsByMobile(mobile);
		if(u1!=null) {
			
			u1.setUsername(username);
			return userRepository.getDetailsByMobile(mobile);
			
		}else {
			throw new GlobalException("user not found with Mobile"+mobile);
		}
		
	}

	@Override
	public List<User> getAllusers() {
		List<User> users=userRepository.findAll();
		return users;
	}

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User updatePassword(String mobilenumber, String oldpass, String newpass) throws GlobalException {
		User user=userRepository.getDetailsByMobile(mobilenumber);
		if(oldpass!=user.getPassword()) {
			user.setPassword(newpass);
			return user;						
		} else {
			throw new GlobalException("You have entered wrong password");
					
		}

				
	}
	
	@Override
	public User updateUser(User user, Integer id) {
		User updatetodo = userRepository.findById(id).get();
		updatetodo.setUsername(user.getUsername());
		updatetodo.setFirstname(user.getFirstname());
		updatetodo.setLastname(user.getLastname());
		updatetodo.setEmail(user.getEmail());
		updatetodo.setPassword(user.getPassword());
		updatetodo.setMobilenumber(user.getMobilenumber());
		updatetodo.setDob(user.getDob());
		updatetodo.setGender(user.getGender());
		userRepository.save(updatetodo);
		return updatetodo;
	}

}
