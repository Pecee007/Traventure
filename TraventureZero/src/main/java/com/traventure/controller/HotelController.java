package com.traventure.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.traventure.domain.HotelDetail;
import com.traventure.domain.JsonResponse;
import com.traventure.mongoRepository.HotelDetailRepo;
import com.traventure.services.SortHotelByRating;

@Controller
//@RequestMapping(value = "/traventure")
@RequestMapping(value = {"/","/user"})
public class HotelController {
	
	@Autowired
	HotelDetailRepo hotelrepo;
	
	 Gson gson = new GsonBuilder().create();
	
	ArrayList<HotelDetail> hotels = new ArrayList<HotelDetail>();
	ArrayList<HotelDetail> hotels1 = new ArrayList<HotelDetail>();
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/search.htm", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody JsonResponse search(@RequestParam("placename")String placename, 
			@RequestParam("username")String username, Model model) {
		
		JsonResponse res = new JsonResponse();
		
/*		System.out.println("Searching for hotels");
		HotelDetail h;
		JsonResponse res = new JsonResponse();	//used for converting objects into json format.

		//inserts sample documents into hotelDetail collection in the database if no documents are found.
		if(hotelrepo.count() == 0){ //count number of documents and insert sample docs if nothing found
			
			h = new HotelDetail("Vivanta By TAJ","The brand Vivanta was born as a part of Taj Hotels Resorts and Palaces' (also known as The Indian Hotels Company Limited) brand architecture exercise. With this the brand rolled over 19 of its hotels to the new brand.","Kolkata",3);
			hotelrepo.save(h);
			h = new HotelDetail("The Chancery Pavillion","The brand Vivanta was born as a part of Taj Hotels Resorts and Palaces' (also known as The Indian Hotels Company Limited) brand architecture exercise. With this the brand rolled over 19 of its hotels to the new brand.","Mumbai",1.5);
			hotelrepo.save(h);
			h = new HotelDetail("Keys Whitefield Bengaluru","The brand Vivanta was born as a part of Taj Hotels Resorts and Palaces' (also known as The Indian Hotels Company Limited) brand architecture exercise. With this the brand rolled over 19 of its hotels to the new brand.","Bangalore",2.8);
			hotelrepo.save(h);
			h = new HotelDetail("Vivanta By TAJ","The brand Vivanta was born as a part of Taj Hotels Resorts and Palaces' (also known as The Indian Hotels Company Limited) brand architecture exercise. With this the brand rolled over 19 of its hotels to the new brand.","Delhi",2);
			hotelrepo.save(h);
			h = new HotelDetail("The Pride Hotel","There's a Mediterranean restaurant/bar, plus a trendy eatery with live music and a sleek cafe with buffet and a la carte dining options. Other amenities include a spa and a business centre.","Kolkata",1);
			hotelrepo.save(h);
			h = new HotelDetail("Vivanta By TAJ","The brand Vivanta was born as a part of Taj Hotels Resorts and Palaces' (also known as The Indian Hotels Company Limited) brand architecture exercise. With this the brand rolled over 19 of its hotels to the new brand.","Mumbai",3.3);
			hotelrepo.save(h);
			h = new HotelDetail("Lemon Tree Hotel","There’s a casual multi-cuisine cafe, and a pan-Asian restaurant serves street food. Other amenities include a trendy bar with a PlayStation and a pool table, a fitness room, a spa, and an outdoor pool. Free breakfast and parking are provided.","Bangalore",5);
			hotelrepo.save(h);
			h = new HotelDetail("Vivanta By TAJ","The brand Vivanta was born as a part of Taj Hotels Resorts and Palaces' (also known as The Indian Hotels Company Limited) brand architecture exercise. With this the brand rolled over 19 of its hotels to the new brand.","Mumbai",1.5);
			hotelrepo.save(h);
			h = new HotelDetail("The Woodbridge Hotel","There’s a casual multi-cuisine cafe, and a pan-Asian restaurant serves street food. Other amenities include a trendy bar with a PlayStation and a pool table, a fitness room, a spa, and an outdoor pool. Free breakfast and parking are provided.","Delhi",4);
			hotelrepo.save(h);
			
			//h = new HotelDetail("","",""); //template
			//hotelrepo.save(h);
			logger.info(hotelrepo + "Movie Details successfully saved");
		}
		

 		if(hotelrepo==null){
			logger.info("movieRepository is null");
		}else{
			logger.info("movieRepository is not null");
			//hotelrepo.save(h);
			//logger.info(hotelrepo + "Movie Details successfully saved");
			//hotels = (List<HotelDetail>) hotelrepo.findAll();
			//hotels = (List<HotelDetail>) hotelrepo.searchByHotelLocation(placename);
		}
		

		//Convert the location in sentence case to make it uniform for string matching.
		String location=placename;
		int locLength = placename.length();
		if(locLength > 0){
			if(locLength>1)
				location = placename.substring(0, 1).toUpperCase();
			location = location + placename.substring(1, locLength).toLowerCase();
			//logger.info(location);
		}
		if(locLength == 0){
			hotels = (ArrayList<HotelDetail>) hotelrepo.findAll();
			System.out.println("Size: "+hotels.size());
			logger.info("Hotel[1] = "+hotels.get(8).getHotel_name());
		}
		else{
			hotels = (ArrayList<HotelDetail>) hotelrepo.searchByHotelLocation(location);
			
			for(HotelDetail hotel : hotels){
				System.out.println("Hotel name: "+hotel.getHotel_name()+"  "+hotel.getHotel_location());
			}
			//System.out.println("Hotels in location: " + hotels);
			
		}
		
		//Sort hotels in descending order to display the top rated hotel first.
		SortHotelByRating ms = new SortHotelByRating(hotels);
		
		hotels = ms.getSortedArray();
		System.out.println("--------Before Sorting------");
		for(HotelDetail h1:ms.getSortedArray()){
            System.out.println(h1.getHotel_name()+" "+h1.getHotel_rating());
        }
		
		ms.sortGivenArray();
		
		//Comparator comparator = Collections.reverseOrder();
		//Collections.sort(hotels,comparator);
		
		//System.out.println("--------After Sorting------");
		
		hotels = ms.getSortedArray();
		
		for(HotelDetail h1:ms.getSortedArray()){
            System.out.println(h1.getHotel_name()+" "+h1.getHotel_rating());
        }

		
*/		
		hotels = searchHotels(placename);
		
		
		System.out.println("Object List"+hotels);
		String a = gson.toJson(hotels);
		System.out.println("JSON:"+a);

			if(!hotels.isEmpty()){
				res.setStatus("SUCCESS");
				res.setLength(hotels.size());
				/*if(hotels.size()>5)
					res.setResult(hotels.subList(0, 5));
				else*/
					res.setResult(hotels);
			}
			else{
				res.setStatus("FAIL");
			}
            

	        //res.setStatus("FAIL");
		model.addAttribute("hotels",hotels);
		
		//return "homepage";
		return res;
	}
	
	

	
	
	
	public ArrayList<HotelDetail> searchHotels(String placename) {
		
		System.out.println("Searching for hotels");
		ArrayList<HotelDetail> hotels = new ArrayList<HotelDetail>();
		//HotelDetail h = new HotelDetail();
		

		//Convert the location in sentence case to make it uniform for string matching.
		String location=placename;
		int locLength = placename.length();
		if(locLength > 0){
			if(locLength>1)
				location = placename.substring(0, 1).toUpperCase();
			location = location + placename.substring(1, locLength).toLowerCase();
			//logger.info(location);
		}
		
		if(locLength == 0){
			hotels = (ArrayList<HotelDetail>) hotelrepo.findAll();
			System.out.println("Size: "+hotels.size());
		}
		else{
			hotels = (ArrayList<HotelDetail>) hotelrepo.searchByHotelLocation(location);
			
			for(HotelDetail hotel : hotels){
				System.out.println("Hotel name: "+hotel.getHotel_name()+"  "+hotel.getHotel_location());
			}
		}
		
		//Sort hotels in descending order to display the top rated hotel first.
		SortHotelByRating ms = new SortHotelByRating(hotels);
/*		
		hotels = ms.getSortedArray();
		System.out.println("--------Before Sorting------");
		for(HotelDetail h1:ms.getSortedArray()){
            System.out.println(h1.getHotel_name()+" "+h1.getHotel_rating());
        }
*/		
		ms.sortGivenArray();
		
		//Comparator comparator = Collections.reverseOrder();
		//Collections.sort(hotels,comparator);
		
		//System.out.println("--------After Sorting------");
		
		hotels = ms.getSortedArray();
/*		
		for(HotelDetail h1:ms.getSortedArray()){
            System.out.println(h1.getHotel_name()+" "+h1.getHotel_rating());
        }
*/
		
		return hotels;
    }
	
}
