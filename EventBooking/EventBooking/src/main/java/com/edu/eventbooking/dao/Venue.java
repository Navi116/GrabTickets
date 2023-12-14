package com.edu.eventbooking.dao;

import java.util.Arrays;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Venue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
		
	@Pattern(message = "Venue should contain only alphabets", regexp = "^[a-zA-Z ]*$")
	@Column(length = 30, nullable = false)
	@NotBlank(message = "venue shouldn't be blank")
	private String venuename;
	
	@Column(nullable = false,length = 20)
	private String venuecategory;
	
	@Column(nullable = false)
	private int seatcapacity;
	
	@Column(nullable = false, unique=true,length = 70)
	private String  street;
	
	@Pattern(message = "City should contain only alphabets", regexp = "^[a-zA-Z ]*$")
	@Column(nullable = false, length = 20)
	private String city; 
	
	@Pattern(message = "State should contain only alphabets", regexp = "^[a-zA-Z ]*$")
	@Column(nullable = false, length = 20)
	private String state;
	
	@Pattern(message = "Pincode should contain 6 numbers And starts from  1-9", regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$")
	@Column(nullable = false, length = 6)
	private String pincode; 
	
	@Column(nullable = false)
	private String description ;
	
	@Column(nullable = false)
	private float rent;
	
	
	@Column(nullable = false)
	private String venuedocuments;
	
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "pid")
	private Partner partner;
	
		

	public Venue() {
		super();
		
	}

	public Venue(String venuename,String venuecategory, int seatcapacity, String street, String city, String state, String pincode,
			String description, float rent, String venuedocuments) {
		super();
		this.venuename = venuename;
		this.seatcapacity = seatcapacity;
		this.venuecategory=venuecategory;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.description=description;
		this.rent = rent;
		this.venuedocuments = venuedocuments;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getVenuename() {
		return venuename;
	}

	public void setVenuename(String venuename) {
		this.venuename = venuename;
	}

	public String getVenuecategory() {
		return venuecategory;
	}

	public void setVenuecategory(String venuecategory) {
		this.venuecategory = venuecategory;
	}

	public int getSeatcapacity() {
		return seatcapacity;
	}

	public void setSeatcapacity(int seatcapacity) {
		this.seatcapacity = seatcapacity;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getRent() {
		return rent;
	}

	public void setRent(float rent) {
		this.rent = rent;
	}

	public String getVenuedocuments() {
		return venuedocuments;
	}

	public void setVenuedocuments(String venuedocuments) {
		this.venuedocuments = venuedocuments;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	@Override
	public String toString() {
		return "Venue [id=" + id + ", venuename=" + venuename + ", venuecategory=" + venuecategory + ", seatcapacity="
				+ seatcapacity + ", street=" + street + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ ", description=" + description + ", rent=" + rent + ", venuedocuments=" + venuedocuments + ", status="
				+ status + ", partner=" + partner + "]";
	}



	
	
	

	
	
		
	

}
