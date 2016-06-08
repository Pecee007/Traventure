package com.examples.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListSortingExample {

	private static class SmartPhone implements Comparable<Object> {
	
		private String brand;
		private String model;
		private int price;
		
		public SmartPhone(String brand, String model, int price) {
			this.brand = brand;
			this.model = model;
			this.price = price;
		}
		
		@Override
		public int compareTo(Object sp) {
			return this.brand.compareTo(((SmartPhone) sp).brand);
		}
		
		@Override
		public String toString() {
			return "SmartPhone{" + "brand=" + brand + ", model=" + model + ", price=" + price + '}';
		}
	
	}

	private static class PriceComparator implements Comparator<Object> {
		@Override
		public int compare(Object sp1, Object sp2) {
			return (((SmartPhone) sp1).price < ((SmartPhone) sp2).price) ? -1 
					: (((SmartPhone) sp1).price > ((SmartPhone) sp2).price) ? 1 : 0;
		}
	}

    public static void main(String... args) {
      
        //creating objects for arraylist sorting example
        SmartPhone apple = new SmartPhone("Apple", "IPhone4S",1000);
        SmartPhone nokia = new SmartPhone("Nokia", "Lumia 800",600);
        SmartPhone samsung = new SmartPhone("Samsung", "Galaxy Ace",800);
        SmartPhone lg = new SmartPhone("LG", "Optimus",500);
        SmartPhone op = new SmartPhone("LG", "Optimus",100);
      
        //creating Arraylist for sorting example
        ArrayList<SmartPhone> smartPhones = new ArrayList<SmartPhone>();
      
        //storing objects into ArrayList for sorting
        smartPhones.add(apple);
        smartPhones.add(nokia);
        smartPhones.add(samsung);
        smartPhones.add(lg);
        smartPhones.add(op);
      
        //Sorting Arraylist in Java on natural order of object
        //Collections.sort(smartPhones);
        Collections.sort(smartPhones, Collections.reverseOrder());
        //print sorted arraylist on natural order
        System.out.println(smartPhones);
      
        //Sorting Arraylist in Java on custom order defined by Comparator
        Collections.sort(smartPhones,new PriceComparator());
      
        //print sorted arraylist on custom order
        System.out.println(smartPhones);
    
    }
}
