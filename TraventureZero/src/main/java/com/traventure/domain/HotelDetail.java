package com.traventure.domain;

import org.springframework.data.annotation.Id;

public class HotelDetail {

	@Id
	 private String id;
	 private String hotel_name;  
	 private String hotel_description;
	 private String hotel_location;
	 
	public HotelDetail(){}
	 
	
	 public HotelDetail(String hotel_name, String hotel_description, String hotel_location) {
		//super();
		this.hotel_name = hotel_name;
		this.hotel_description = hotel_description;
		this.hotel_location = hotel_location;
	}
	 
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getHotel_description() {
		return hotel_description;
	}
	public void setHotel_description(String hotel_description) {
		this.hotel_description = hotel_description;
	}
	
	 public String getHotel_location() {
		return hotel_location;
	}

	public void setHotel_location(String hotel_location) {
		this.hotel_location = hotel_location;
	}
	
	@Override
	public String toString() {
		return "HotelDetails [id=" + id + ", hotel_name=" + hotel_name + ", hotel_description=" + hotel_description + ", hotel_location=" + hotel_location + "]";
	}

	
	
}
