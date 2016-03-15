package com.traventure.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.traventure.domain.HotelDetail;
import com.traventure.mongoRepository.HotelDetailRepo;

@Controller
public class SampleController {
	
	@Autowired
	HotelDetailRepo hotelrepo;
	
	List<HotelDetail> hotels = new ArrayList<HotelDetail>();
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam("placename")String placename, @RequestParam("username")String username, Model model) {
		System.out.println("Searching for hotels");
		HotelDetail h;
		
		//inserts sample documents into database if no documents are found
		if(hotelrepo.count() == 0){ //count number of documents and insert sample docs if nothing found
			
			h = new HotelDetail("Vivanta By TAJ","The brand Vivanta was born as a part of Taj Hotels Resorts and Palaces' (also known as The Indian Hotels Company Limited) brand architecture exercise. With this the brand rolled over 19 of its hotels to the new brand.","Mumbai");
			hotelrepo.save(h);
			h = new HotelDetail("Vivanta By TAJ","The brand Vivanta was born as a part of Taj Hotels Resorts and Palaces' (also known as The Indian Hotels Company Limited) brand architecture exercise. With this the brand rolled over 19 of its hotels to the new brand.","Bangalore");
			hotelrepo.save(h);
			h = new HotelDetail("The Pride Hotel","There's a Mediterranean restaurant/bar, plus a trendy eatery with live music and a sleek cafe with buffet and a la carte dining options. Other amenities include a spa and a business centre.","Mumbai");
			hotelrepo.save(h);
			h = new HotelDetail("Lemon Tree Hotel","There’s a casual multi-cuisine cafe, and a pan-Asian restaurant serves street food. Other amenities include a trendy bar with a PlayStation and a pool table, a fitness room, a spa, and an outdoor pool. Free breakfast and parking are provided.","Bangalore");
			hotelrepo.save(h);
			h = new HotelDetail("The Woodbridge Hotel","There’s a casual multi-cuisine cafe, and a pan-Asian restaurant serves street food. Other amenities include a trendy bar with a PlayStation and a pool table, a fitness room, a spa, and an outdoor pool. Free breakfast and parking are provided.","Delhi");
			hotelrepo.save(h);
			
			//h = new HotelDetail("","",""); //template
			//hotelrepo.save(h);
			logger.info(hotelrepo + "Movie Details successfully saved");
		}
		
/*		if(hotelrepo==null){
			logger.info("movieRepository is null");
		}else{
			logger.info("movieRepository is not null");
			//hotelrepo.save(h);
			//logger.info(hotelrepo + "Movie Details successfully saved");
			//hotels = (List<HotelDetail>) hotelrepo.findAll();
			//hotels = (List<HotelDetail>) hotelrepo.searchByHotelLocation(placename);
		}
		
*/
		
		String location=placename;
		int locLength = placename.length();
		if(locLength > 0){
			if(locLength>1)
				location = placename.substring(0, 1).toUpperCase();
			location = location + placename.substring(1, locLength).toLowerCase();
			//logger.info(location);
		}
		if(locLength == 0)
			hotels = (List<HotelDetail>) hotelrepo.findAll();
		else{
			hotels = (List<HotelDetail>) hotelrepo.searchByHotelLocation(location);
		}
		model.addAttribute("hotels",hotels);
		return "homepage";
	}
	
}
