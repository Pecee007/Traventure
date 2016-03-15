package com.traventure.dao;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.traventure.domain.HotelDetail;

public class HotelDaoImpl implements HotelDao{

	public List<HotelDetail> getHotelList(){
		
		try {
			MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new Mongo(), "hotel"));
			List<HotelDetail> hoteList = mongoOps.findAll(HotelDetail.class);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
