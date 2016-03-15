package com.traventure.mongoRepository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.traventure.domain.HotelDetail;


public interface HotelDetailRepo extends CrudRepository<HotelDetail, Long> {
	
	@Query("{'hotel_name' : ?0}")
	public Iterable<HotelDetail> searchByHotelName(String hotelName);
	
	@Query("{'hotel_location' : ?0}")
	public Iterable<HotelDetail> searchByHotelLocation(String hotelLocation);
}
