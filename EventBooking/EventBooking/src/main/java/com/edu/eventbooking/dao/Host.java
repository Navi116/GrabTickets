package com.edu.eventbooking.dao;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Host {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "Firstname Shouldn't be blank")
	@Column(nullable = false, length = 20)
	private String firstname;
	
	@NotBlank(message = "Lastname Shouldn't be blank")
	@Column(nullable = false ,length = 20)
	private String lastname;
	
	@NotBlank(message = " Username Shouldn't be blank")
	@Column(nullable = false, length = 20)
	private String username;	

	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$", 
			message = "Password should contain combination of Atleast 1 uppercase, "
					+ "1 lowercase, 1 special character And Minimum 8 chars long")
	@Column(nullable = false)
	private String password;
	
	@Pattern(message = "aadhar should be 12 digit", regexp = "^\\d{12}$")
	@Column(nullable = false, unique = true)
	@NotBlank(message = "Shouldn't be blank")
	private String aadharno;	
	
	@Pattern(message = "Invalid Phone Number", regexp = "^[6-9]\\d{9}$")
	@Column(unique = true, nullable = false, length = 10)
	private String mobilenumber;
	
	@Email(message = "Invalid Email", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	@Column(nullable = true, length =30, unique = true )	
	private String email;
	
	@NotBlank(message = "Address Shouldn't be blank")
	@Column(nullable = false, length = 60)
	private String address;
	
	
	

public Host() {
		super();
		// TODO Auto-generated constructor stub
	}


public Host(String firstname, String lastname, String username, String password, String aadharno, String mobilenumber,
		String email, String address) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.username = username;
	this.password = password;
	this.aadharno = aadharno;
	this.mobilenumber = mobilenumber;
	this.email = email;
	this.address = address;
}


public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public String getFirstname() {
	return firstname;
}


public void setFirstname(String firstname) {
	this.firstname = firstname;
}


public String getLastname() {
	return lastname;
}


public void setLastname(String lastname) {
	this.lastname = lastname;
}


public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getAadharno() {
	return aadharno;
}


public void setAadharno(String aadharno) {
	this.aadharno = aadharno;
}


public String getMobilenumber() {
	return mobilenumber;
}


public void setMobilenumber(String mobilenumber) {
	this.mobilenumber = mobilenumber;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


@Override
public String toString() {
	return "Host [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
			+ ", password=" + password + ", aadharno=" + aadharno + ", mobilenumber=" + mobilenumber + ", email="
			+ email + ", address=" + address + "]";
}	

	
	
	
	
}
