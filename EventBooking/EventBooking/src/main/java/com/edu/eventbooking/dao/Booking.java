package com.edu.eventbooking.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Booking {

	@Id
	private String bookingid;

	@Column(name="showname",length=70,nullable = false)
    @NotBlank(message = "Show name should not be blank")
	private String showname;
	
	@Column(name="showdate",nullable = false)
	@Future(message = "Show date should be in the future")
	private Date showdate;
	
	@Column(name="showtimings",nullable = false)
	private Time showtimings;
	
	@Column(name="costcategory",nullable=false)
	private float costcategory;	
	@Column(nullable = false)
	private int seats;
	
	@Column(nullable = false)
	private String venuename;

	public Booking() {
		super();
		this.bookingid =GenerateRandomIdUtil.generateRandomId(12);
			}	
	
	
	public Booking( String showname,Date showdate, Time showtimings, float costcategory,
			int seats, String venuename) {
		super();
		this.showname = showname;
		this.showdate = showdate;
		this.showtimings = showtimings;
		this.costcategory = costcategory;
		this.seats = seats;
		this.venuename = venuename;
	}



	public String getBookingid() {
		return bookingid;
	}

	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}

	public String getShowname() {
		return showname;
	}

	public void setShowname(String showname) {
		this.showname = showname;
	}

	public Date getShowdate() {
		return showdate;
	}

	public void setShowdate(Date showdate) {
		this.showdate = showdate;
	}

	public Time getShowtimings() {
		return showtimings;
	}

	public void setShowtimings(Time showtimings) {
		this.showtimings = showtimings;
	}

	public float getCostcategory() {
		return costcategory;
	}

	public void setCostcategory(float costcategory) {
		this.costcategory = costcategory;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getVenuename() {
		return venuename;
	}

	public void setVenuename(String venuename) {
		this.venuename = venuename;
	}


	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ", showname=" + showname + ", showdate=" + showdate
				+ ", showtimings=" + showtimings + ", costcategory=" + costcategory + ", seats=" + seats
				+ ", venuename=" + venuename + "]";
	}
	
	




}
