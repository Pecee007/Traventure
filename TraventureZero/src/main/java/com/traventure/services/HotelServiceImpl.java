package com.traventure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.traventure.dao.HotelDao;
import com.traventure.domain.HotelDetail;


public class HotelServiceImpl {
	
	@Autowired
	HotelDao hoteldao;
	
	public List<HotelDetail> getHotelList() {
		return hoteldao.getHotelList();
	}
}
