package com.edu.eventbooking.controller;

//import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.edu.eventbooking.dao.User;
import com.edu.eventbooking.error.GlobalException;
import com.edu.eventbooking.repository.UserRepository;
//import com.edu.eventbooking.service.ShowsService;
import com.edu.eventbooking.service.UserService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")//connect with ang
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private ShowsService showsService;
	

	
	// Register user details
	@PostMapping("/addUser")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user){
		User checkuser=userRepository.getDetailsByMobile(user.getMobilenumber());
		if(checkuser!=null) {
			return ResponseEntity.badRequest().body(null);
		}
		User newuser=userService.registerUser(user);
		return new ResponseEntity<User>(newuser, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/checkUserByPass/{umail}/{pass}")
	private ResponseEntity<User> checkUserByPass(@Valid @PathVariable("umail") String mail,@PathVariable("pass") String pass) {
		User existinguser=userRepository.getUserByMailPass(mail,pass);
//		System.out.println(existinguser);
//		if ( existinguser!= null) {
//			System.out.println("User exists");
//		      return new ResponseEntity<User>(existinguser, HttpStatus.ACCEPTED); 
//		      		// Return an error response if already registered
//		  }
//		else  return ResponseEntity.badRequest().body(null); 
		
		if (existinguser != null) {
    		System.out.println("User exists");
    		System.out.println(existinguser);
  	        return ResponseEntity.status(HttpStatus.ACCEPTED).body(existinguser); 
  	        		// Return an error response if already registered
  	    }
    	else  return ResponseEntity.badRequest().body(null); 
    
	}
	
	@GetMapping("/checkUserByEmail/{umail}")
	private ResponseEntity<User> checkUserByEmail(@Valid @PathVariable("umail") String mail) {
		User existinguser = userRepository.findbyEmail(mail);
		
		if (existinguser != null) {
    		System.out.println("User exists");
    		System.out.println(existinguser);
  	        return ResponseEntity.status(HttpStatus.ACCEPTED).body(existinguser); 
  	        		// Return an error response if already registered
  	    }
    	else  return ResponseEntity.badRequest().body(null); 
    
	}
	
	@PutMapping("/editUsername/{mobile}/{un}")
	public User editUsername(@PathVariable("mobile") String mobile, @PathVariable("un") String username) throws GlobalException {
		return userService.editUsername(mobile,username);
		
}
	@GetMapping("/getAllUsers")
	public java.util.List<User> getAllUsers() {
		return userService.getAllusers();
	}
	
	@PutMapping("/updatePassword/{mobile}/{oldpass}/{newpass}")
	public User updatePassword(@PathVariable("mobile") String mobilenumber, @PathVariable("oldpass") String oldpass, @PathVariable("newpass") String newpass) throws GlobalException {
		
		return userService.updatePassword(mobilenumber,oldpass,newpass);
	}
	
	@PutMapping("/updateuser/{id}")
    public User updateUser(@PathVariable("id") Integer id,@RequestBody User user) {
    	return userService.updateUser(user,id);
    	
      // return todo.getUsername()+" registered successfully";
    }
	
	@GetMapping("/getUserbyId/{id}")
	public User getUserbyId(@Valid @PathVariable("Id") Integer id) {
		User checkUser = userRepository.findById(id).get();
		return checkUser;
	}
	
	
	
	
	
	

}
