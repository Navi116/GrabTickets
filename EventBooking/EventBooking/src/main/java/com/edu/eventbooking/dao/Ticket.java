package com.edu.eventbooking.dao;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Ticket {
	
	
	 // this generates the Random booking id through GenerateRandomIdUtil.generateRandomId(12); 
//	the method takes a number to generate that number size
	@Id
	@Column(nullable = false, unique = true)
	private String bookingid;	
	
	@NotBlank(message = "Moviename shouldn't be blank")
	@Column(nullable= false, length = 40)
	private String showname;
	
	@NotBlank(message = "venue name shouldn't be blank")
	@Column( nullable = false, length= 40)
	private String venue;
	
	@NotBlank(message = "Theatre address shouldn't be blank")
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private int seats;
	
		
	@Column(nullable = false, length=3)
	private float price;
	
	@Future(message = "Showdate should be in future")
	@Column(nullable = false)
	private Date date;
	
	@Column(nullable = false)
	private Time showtime;
	
	
	@ManyToOne
	@JoinColumn(name="email")
	private User user;
	
		
	

	public Ticket() {
		super();
		
		this.bookingid=GenerateRandomIdUtil.generateRandomId(12);
	}

	public Ticket(String showname, String venue, String address, int seats,  float price, Date date, Time showtime) {
		super();
		this.showname=showname;
		this.venue=venue;
		this.address=address;
		this.seats= seats;
		this.price = price;
		this.date = date;
		this.showtime = showtime;
	}

	public String getBookingid() {
		return bookingid;
	}

	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}

	
	

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getShowtime() {
		return showtime;
	}

	public void setShowtime(Time showtime) {
		this.showtime = showtime;
	}



	public String getShowname() {
		return showname;
	}

	public void setShowname(String showname) {
		this.showname = showname;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Ticket [bookingid=" + bookingid + ", showname=" + showname + ", venue=" + venue + ", address=" + address
				+ ", seats=" + seats + ", price=" + price + ", date=" + date + ", showtime=" + showtime + ", user="
				+ user + "]";
	}

	
	
	

	
	
	
	
	
	
	

}
