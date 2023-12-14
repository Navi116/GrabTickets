package com.edu.eventbooking.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="shows")
public class Shows {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer showid;
	@Column(nullable = false)
	private String showcategory;
	
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

	@Column(name="Available_seats",nullable = false)
	private int availableseats;
	
	@Column(nullable = false)
	private int seatcapacity;	
	
	
	@ManyToOne
	private Host host;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Venue venue;
	
	
	public Shows() {
		super();
		
	}
	
	public Shows( String showname,String showcategory, Date showdate, Time showtimings, float costcategory, int seatcapacity) {
		super();
		this.showname = showname;
		this.showcategory=showcategory;
		this.showdate = showdate;
		this.showtimings = showtimings;
		this.costcategory = costcategory;
		this.availableseats = seatcapacity;
		this.seatcapacity=seatcapacity;
		
	}

	public Integer getShowid() {
		return showid;
	}

	public void setShowid(Integer showid) {
		this.showid = showid;
	}

	public String getShowcategory() {
		return showcategory;
	}

	public void setShowcategory(String showcategory) {
		this.showcategory = showcategory;
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

	public int getAvailableseats() {
		return availableseats;
	}

	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}

	public int getSeatcapacity() {
		return seatcapacity;
	}

	public void setSeatcapacity(int seatcapacity) {
		this.seatcapacity = seatcapacity;
	}

	public Host getHost() {
		return host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	@Override
	public String toString() {
		return "Shows [showid=" + showid + ", showcategory=" + showcategory + ", showname=" + showname + ", showdate="
				+ showdate + ", showtimings=" + showtimings + ", costcategory=" + costcategory + ", availableseats="
				+ availableseats + ", seatcapacity=" + seatcapacity + ", host=" + host + ", venue=" + venue + "]";
	}

	

	
	

	

}
