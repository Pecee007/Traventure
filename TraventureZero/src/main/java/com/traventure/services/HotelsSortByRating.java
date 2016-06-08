package com.traventure.services;

import java.util.ArrayList;
import java.util.List;

import com.traventure.domain.HotelDetail;

public class HotelsSortByRating {
     
    //private int[] array;
    //private int[] tempMergArr;
    private int length;
    //HotelDetail h1 = new HotelDetail("Vivanta By TAJ","The brand Vivanta dfgdg","Kolkata",1);
    //HotelDetail h2 = new HotelDetail("Vivanta By TAJ","The brand Vivanta dfgdg","Kolkata",1);  
    List<HotelDetail> hotels;     
    List<HotelDetail> resultHotels = new ArrayList<HotelDetail>();
    List<HotelDetail> tempHotels = new ArrayList<HotelDetail>();     
 
/*    public static void main(String a[]){
         
        //int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        List<HotelDetail> hotels1 = new ArrayList<HotelDetail>();
        //hotels1 = {h1,h2,..}
        HotelsSortByRating mms = new HotelsSortByRating();
        mms.sort(hotels1);
        for(HotelDetail i:hotels1){
            System.out.print(i);
            System.out.print(" ");
        }
    }*/
    
   // ______________________________________________________________________________________________________
    // Please follow this link
   // http://www.snippetexample.com/2014/10/mergesort-implementation-example-using-arraylist-java/
   // ____________________________________________________________________________________________________
    
    public List<HotelDetail> sort(List<HotelDetail> hotelList) {
    	System.out.println("Inside sort: "+hotelList);
        this.hotels = new ArrayList<HotelDetail>();
        for(HotelDetail h : hotelList){
        	hotels.add(h);
        	//System.out.println("Hotels: "+h.getHotel_location()+",  "+h.getHotel_name());
        }
        for(HotelDetail h : hotels){
        	System.out.println("Hotels: "+h.getHotel_location()+",  "+h.getHotel_name());
        }
        this.length = hotels.size();
        //this.tempHotels = new ArrayList<HotelDetail>();
        System.out.println("The length: "+length);
        doMergeSort(0, length - 1);
		return resultHotels;
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex) {
    	for(HotelDetail h : hotels){
        	System.out.println("Hotels1111: "+h.getHotel_location()+",  "+h.getHotel_name());
        }
         System.out.println("index1: "+lowerIndex+" index2: "+higherIndex);
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            //tempMergArr[i] = array[i];
            //tempHotels.set(i, hotels.get(i));
            tempHotels.add(i, hotels.get(i));
            System.out.println("Current: "+hotels.get(i).getHotel_name()+", Loc: "+hotels.get(i).getHotel_location());
        }
        for (int i = lowerIndex; i <= higherIndex; i++) {
            //tempMergArr[i] = array[i];
            System.out.println("TempHotels List = "+tempHotels.get(i).getHotel_name()+", Loc = "+tempHotels.get(i).getHotel_location());
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        
        while (i <= middle && j <= higherIndex) {
        	System.out.println("indexes in: "+i+" "+j+" "+k);
        	
            if (tempHotels.get(i).getHotel_rating() <= tempHotels.get(j).getHotel_rating()) {
                //array[k] = tempMergArr[i];
            	System.out.println("Hotel["+i+"] r: "+tempHotels.get(i).getHotel_rating()+" <= "+"Hotel["+j+"] r: "+tempHotels.get(j).getHotel_rating());
            	//System.out.println("Hotel["+j+"] r: "+tempHotels.get(j).getHotel_rating());
            	resultHotels.add(k, tempHotels.get(i));
                i++;
            } else {
                //array[k] = tempMergArr[j];
            	System.out.println("Hotel["+i+"] r: "+tempHotels.get(i).getHotel_rating()+" > "+"Hotel["+j+"] r: "+tempHotels.get(j).getHotel_rating());
            	resultHotels.add(k, tempHotels.get(j));
                j++;
            }
            k++;
        }System.out.println("indexes: "+i+" "+j+" "+k);
        System.out.println("indexes out: "+i+" "+j+" "+k);
/*        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }*/
        while (i <= middle) {
            //array[k] = tempMergArr[i];
        	System.out.println("i here");
        	resultHotels.add(k, tempHotels.get(i));
            k++;
            i++;
        }
        
        while (j <= higherIndex) {
        	System.out.println("j here");
        	resultHotels.add(k, tempHotels.get(j));
        	k++;
        	j++;
        }
/*        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }*/
 
    }
}