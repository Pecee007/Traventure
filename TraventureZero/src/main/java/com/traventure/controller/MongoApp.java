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

	  public static void main(String[] args) throws Exception {

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

	    
	    mongoOps.dropCollection(Person.class);
	  }
}
