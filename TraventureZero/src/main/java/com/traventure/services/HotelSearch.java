/*
 * Not used
 * Not usable
 * Testing purposes
 * Errors prone
*/





package com.traventure.services;

import java.util.ArrayList;

import com.traventure.domain.HotelDetail;
import com.traventure.mongoRepository.HotelDetailRepo;

public class HotelSearch {
	public ArrayList<HotelDetail> searchHotels(String placename) {
		
		System.out.println("Searching for hotels");
		ArrayList<HotelDetail> hotels = new ArrayList<HotelDetail>();
		HotelDetail h = new HotelDetail();
		HotelDetailRepo hotelrepo;
		

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
			//hotels = (ArrayList<HotelDetail>) hotelrepo.findAll();
			System.out.println("Size: "+hotels.size());
		}
		else{
			//hotels = (ArrayList<HotelDetail>) hotelrepo.searchByHotelLocation(location);
			
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
