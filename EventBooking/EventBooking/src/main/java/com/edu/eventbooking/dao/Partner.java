package com.edu.eventbooking.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Partner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	
	@NotBlank(message = "shouldn't be blank")
	@Column(length = 20, nullable = false)
	@Pattern(message = "Firstname should contain only alphabets", regexp = "^[a-zA-Z ]*$")
	private String firstname;
	
	@NotBlank(message = "shouldn't be blank")
	@Column(length = 20, nullable = false)
	@Pattern(message = "Lastname should contain only alphabets", regexp = "^[a-zA-Z ]*$")
	private String lastname;	
	
	
	@NotBlank(message = "shouldn't be blank")
	@Column(length = 40, nullable = false)
	@Pattern(message = "name should contain only alphabets", regexp = "^[a-zA-Z ]*$")
	private String name;
	
	
	@Pattern(regexp ="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}", 
			message = "Password should contain combination of Atleast 1 uppercase, "
					+ "1 lowercase, 1 special character And Minimum 8 chars long")
	@Column( length=30,nullable = false)
	private String password;
	
	@NotBlank(message = "shouldn't be blank")
	@Column(unique = true, length = 10,nullable = false)
	@Pattern(message = "Invalid format", regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}")
	private String pancard;

	@Pattern(message = "Invalid Phone Number", regexp = "^[6-9]\\d{9}$")
	@Column(unique = true, length = 10,nullable = false)
	private String mobilenumber;

	@NotBlank(message = "shouldn't be blank")
	@Email(message = "Invalid Email", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	@Column(length =30, unique = true, nullable = false )	
	private String email;
	
		
	@NotBlank(message = "Address shouldn't be blank")
	@Column(length = 60, nullable = false)
	private String address;
	
	private boolean status;
	
	
	 
	public Partner() {
		super();
		System.out.println("zero-param");
	}


	

	public Partner( String firstname, String lastname, String name, String password, String pancard, String mobilenumber, String email, String address) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.name = name;
		this.password=password;
		this.pancard = pancard;
		this.mobilenumber = mobilenumber;
		this.email = email;
		this.address = address;
		
	}




	public Integer getPid() {
		return pid;
	}


	public void setPid(Integer pid) {
		this.pid = pid;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPancard() {
		return pancard;
	}


	public void setPancard(String pancard) {
		this.pancard = pancard;
	}


	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Partner [pid=" + pid + ", firstname=" + firstname + ", lastname=" + lastname + ", name=" + name
				+ ", password=" + password + ", pancard=" + pancard + ", mobilenumber=" + mobilenumber + ", email="
				+ email + ", address=" + address + "]";
	}




	




}
