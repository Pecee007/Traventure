package com.traventure.services;

import java.util.List;

import com.traventure.domain.HotelDetail;

public interface HotelService {
	
	public void insertData(HotelDetail user);

	public List<HotelDetail> getHotelList();
	
	public void deleteData(String id);

	public HotelDetail getUser(String id);

	public void updateData(HotelDetail user);
}
