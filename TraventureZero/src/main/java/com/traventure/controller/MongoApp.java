package com.traventure.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.Mongo;
import com.traventure.domain.HotelDetail;
import com.traventure.domain.Person;

public class MongoApp {
/*	  private static final Log log = LogFactory.getLog(MongoApp.class);

	  public static void main(String[] args) throws Exception {

	    MongoOperations mongoOps = new MongoTemplate(new Mongo(), "database");

	    mongoOps.insert(new Person("Joe", 34));

	    Query q1 = new Query((Criteria.where("name").is("Joe")));
	    Person p1 = mongoOps.findOne(q1, Person.class);
	    System.out.println(p1);
	    
	    System.out.println(p1.getId());
	    System.out.println(p1.getName());
	    System.out.println(p1.getAge());
	    System.out.println(p1.getClass());
	    
	    log.info(mongoOps.findOne(new Query(Criteria.where("name").is("Joe")), Person.class));

	    mongoOps.dropCollection("person");
	  }*/
	
	  private static final Log log = LogFactory.getLog(MongoApp.class);

/*	public static void main(String[] args) throws Exception {

	    MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new Mongo(), "database"));

	    Person p = new Person("Joe", 34);

	    // Insert is used to initially store the object into the database.
	    mongoOps.insert(p);
	    log.info("Insert: " + p);
	    
	    // Find
	    p = mongoOps.findById(p.getId(), Person.class);    
	    log.info("Found: " + p);
	    System.out.println("Hello");
	    // Update
	    mongoOps.updateFirst(new Query(Criteria.where("name").is("Joe")), Update.update("age", 35), Person.class);    
	    p = mongoOps.findOne(new Query(Criteria.where("name").is("Joe")), Person.class);
	    log.info("Updated: " + p);
	    
	    // Delete
	    //mongoOps.remove(p);
	    
	    // Check that deletion worked
	    List<Person> people =  mongoOps.findAll(Person.class);
	    log.info("Number of people = : " + people.size());
	    for(Person person :people){
	    	System.out.println(person.getName());
	    	System.out.println(person.getAge());
	    }
	    
	    //mongoOps.dropCollection(Person.class);
	  }*/
	  
	  public static void main(String[] args) throws Exception {
		    
		    MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new Mongo(), "Traventure"));
		    
		    HotelDetail h = new HotelDetail("Vivanta By TAJ","The brand Vivanta was born as a part of Taj Hotels Resorts and Palaces' (also known as The Indian Hotels Company Limited) brand architecture exercise. With this the brand rolled over 19 of its hotels to the new brand.");
		    mongoOps.insert(h);
		    
		    h = new HotelDetail("The Pride Hotel","There's a Mediterranean restaurant/bar, plus a trendy eatery with live music and a sleek cafe with buffet and a la carte dining options. Other amenities include a spa and a business centre.");
		    mongoOps.insert(h);
		    
		    h = new HotelDetail("Lemon Tree Hotel","There’s a casual multi-cuisine cafe, and a pan-Asian restaurant serves street food. Other amenities include a trendy bar with a PlayStation and a pool table, a fitness room, a spa, and an outdoor pool. Free breakfast and parking are provided.");
		    mongoOps.insert(h);
		    
		    h = new HotelDetail("The Woodbridge Hotel","There’s a casual multi-cuisine cafe, and a pan-Asian restaurant serves street food. Other amenities include a trendy bar with a PlayStation and a pool table, a fitness room, a spa, and an outdoor pool. Free breakfast and parking are provided.");
		    mongoOps.insert(h);
		    
		    h = mongoOps.findById(h.get_id(), HotelDetail.class); 
		    System.out.println("Hello"+h.getHotel_name());

			List<HotelDetail> hotelList = mongoOps.findAll(HotelDetail.class);
			for(HotelDetail hotel : hotelList){
				System.out.println(hotel.get_id());
				System.out.println(hotel.getHotel_name());
				System.out.println(hotel.getHotel_description());
				
			}
			
		  }

}
