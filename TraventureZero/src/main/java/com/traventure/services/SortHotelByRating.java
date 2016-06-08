package com.traventure.services;

import java.util.ArrayList;

import com.traventure.domain.HotelDetail;
 
public class SortHotelByRating {
    private ArrayList<HotelDetail> inputArray;
     
    public ArrayList<HotelDetail> getSortedArray() {
        return inputArray;
    }
 
    public SortHotelByRating(ArrayList<HotelDetail> inputArray){
        this.inputArray = inputArray;
    }
     
    public void sortGivenArray(){       
        divide(0, this.inputArray.size()-1);
    }
     
    public void divide(int startIndex,int endIndex){
         
        //Divide till you breakdown your list to single element
        if(startIndex<endIndex && (endIndex-startIndex)>=1){
            int mid = (endIndex + startIndex)/2;
            divide(startIndex, mid);
            divide(mid+1, endIndex);        
             
            //merging Sorted array produce above into one sorted array
            merger(startIndex,mid,endIndex);            
        }       
    }   
     
    public void merger(int startIndex,int midIndex,int endIndex){
         
        //Below is the mergedarray that will be sorted array Array[i-midIndex] , Array[(midIndex+1)-endIndex]
        ArrayList<HotelDetail> mergedSortedArray = new ArrayList<HotelDetail>();
         
        int leftIndex = startIndex;
        int rightIndex = midIndex+1;
         
        
        while(leftIndex<=midIndex && rightIndex <= endIndex){
        	//Sort the list in descending order!!
            if(inputArray.get(leftIndex).getHotel_rating() >= inputArray.get(rightIndex).getHotel_rating()){
                mergedSortedArray.add(inputArray.get(leftIndex));
                leftIndex++;
            }else{
                mergedSortedArray.add(inputArray.get(rightIndex));
                rightIndex++;
            }
        }
                 
        //Either of below while loop will execute
        while(leftIndex <= midIndex){
            mergedSortedArray.add(inputArray.get(leftIndex));
            leftIndex++;
        }
         
        while(rightIndex <= endIndex){
            mergedSortedArray.add(inputArray.get(rightIndex));
            rightIndex++;
        }
         
        int i = 0;
        int j = startIndex;
        //Setting sorted array to original one
        while(i < mergedSortedArray.size()){
            inputArray.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }
}