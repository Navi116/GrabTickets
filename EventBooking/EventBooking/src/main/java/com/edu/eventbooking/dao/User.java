package com.edu.eventbooking.dao;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "Username Can't be blank")
	@Column(nullable = false, unique = true, length = 40)
	private String username;
	
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()-_+=]).{8,}$", 
			message = "Password should contain combination of Atleast 1 uppercase, "
					+ "1 lowercase, 1 special character And Minimum 8 chars long")
	@Column( nullable = false, length=30)
	private String password;
	
	@Pattern(message = "Invalid Phone Number", regexp = "^[6-9]\\d{9}$")
	@Column(unique = true, nullable = false, length = 10)
		private String mobilenumber;
	
	@Email(message = "Invalid Email", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	@Column(length =30, unique = true )	
	private String email;
	
	@NotBlank(message = "Firstname can't be blank")
	@Column(length =20, nullable = false)
	private String firstname;
	
	@NotBlank(message = "Firstname can't be blank")
	@Column(length =20, nullable = false)
	private String lastname;
	
	@Past(message = "Date of birth should be in past")
	private Date dob;
	
	
	private String gender;

	public User() {
		super();
		
	}

	

	public User(String username, String password, String mobilenumber, String email, String firstname, String lastname,
			Date dob, String gender) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.mobilenumber = mobilenumber;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", mobilenumber=" + mobilenumber
				+ ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob
				+ ", gender=" + gender + "]";
	}

	
	
		
	
	
	
		

	
}
