package com.traventure.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.traventure.domain.User;
import com.traventure.domain.userAuth;
import com.traventure.mongoRepository.HotelDetailRepo;
import com.traventure.mongoRepository.UserSignUpRepo;

@Controller
//@RequestMapping(value = "/traventure")
public class HotelController {
	
	@Autowired
	HotelDetailRepo hotelrepo;
	@Autowired
	UserSignUpRepo userRepo;
	
	 Gson gson = new GsonBuilder().create();
	
	List<HotelDetail> hotels = new ArrayList<HotelDetail>();
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/search", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody JsonResponse search(@RequestParam("placename")String placename, 
			@RequestParam("username")String username, Model model) {
		System.out.println("Searching for hotels");
		HotelDetail h;
		JsonResponse res = new JsonResponse();

		//inserts sample documents into database if no documents are found
		if(hotelrepo.count() == 0){ //count number of documents and insert sample docs if nothing found
			
			h = new HotelDetail("Vivanta By TAJ","The brand Vivanta was born as a part of Taj Hotels Resorts and Palaces' (also known as The Indian Hotels Company Limited) brand architecture exercise. With this the brand rolled over 19 of its hotels to the new brand.","Kolkata",1);
			hotelrepo.save(h);
			h = new HotelDetail("Vivanta By TAJ","The brand Vivanta was born as a part of Taj Hotels Resorts and Palaces' (also known as The Indian Hotels Company Limited) brand architecture exercise. With this the brand rolled over 19 of its hotels to the new brand.","Mumbai",1.5);
			hotelrepo.save(h);
			h = new HotelDetail("Vivanta By TAJ","The brand Vivanta was born as a part of Taj Hotels Resorts and Palaces' (also known as The Indian Hotels Company Limited) brand architecture exercise. With this the brand rolled over 19 of its hotels to the new brand.","Bangalore",2);
			hotelrepo.save(h);
			h = new HotelDetail("Vivanta By TAJ","The brand Vivanta was born as a part of Taj Hotels Resorts and Palaces' (also known as The Indian Hotels Company Limited) brand architecture exercise. With this the brand rolled over 19 of its hotels to the new brand.","Delhi",2.8);
			hotelrepo.save(h);
			h = new HotelDetail("The Pride Hotel","There's a Mediterranean restaurant/bar, plus a trendy eatery with live music and a sleek cafe with buffet and a la carte dining options. Other amenities include a spa and a business centre.","Kolkata",3);
			hotelrepo.save(h);
			h = new HotelDetail("Vivanta By TAJ","The brand Vivanta was born as a part of Taj Hotels Resorts and Palaces' (also known as The Indian Hotels Company Limited) brand architecture exercise. With this the brand rolled over 19 of its hotels to the new brand.","Mumbai",3.3);
			hotelrepo.save(h);
			h = new HotelDetail("Lemon Tree Hotel","There’s a casual multi-cuisine cafe, and a pan-Asian restaurant serves street food. Other amenities include a trendy bar with a PlayStation and a pool table, a fitness room, a spa, and an outdoor pool. Free breakfast and parking are provided.","Bangalore",4);
			hotelrepo.save(h);
			h = new HotelDetail("Vivanta By TAJ","The brand Vivanta was born as a part of Taj Hotels Resorts and Palaces' (also known as The Indian Hotels Company Limited) brand architecture exercise. With this the brand rolled over 19 of its hotels to the new brand.","Mumbai",4.7);
			hotelrepo.save(h);
			h = new HotelDetail("The Woodbridge Hotel","There’s a casual multi-cuisine cafe, and a pan-Asian restaurant serves street food. Other amenities include a trendy bar with a PlayStation and a pool table, a fitness room, a spa, and an outdoor pool. Free breakfast and parking are provided.","Delhi",5);
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
		System.out.println("Object List"+hotels);
		String a = gson.toJson(hotels);
		System.out.println("JSON:"+a);

			if(!hotels.isEmpty()){
				res.setStatus("SUCCESS");
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
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin(/*@RequestParam("username")String username, 
			@RequestParam("password")String password, */Model model) {
		return "jsp/signin";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(@ModelAttribute User user, Model model) {
		return "jsp/signup";
	}
	
	@RequestMapping(value = "/user/signin", method = RequestMethod.POST)
	public String signinUser(@RequestParam("username")String username, 
			@RequestParam("password")String password, Model model) {
		logger.info("");
		logger.info("You are trying to signin");
		User usr = userRepo.getDisplayName(username);
		if(usr == null){
			logger.info("Username does not exist!");
			return "redirect:/signin";
		}
		else{
			if(usr.getPassword().equals(password)){
				model.addAttribute(username,usr.getDisplayName());
				userAuth ua = new userAuth();
				ua.setStatus("SUCCESS");
				ua.setResult(usr.getDisplayName());
				logger.info("Successfully signed in!");
			}
			else{
				model.addAttribute("status", "Fail");
				logger.info("Username and  password does not match!!");
				return "redirect:/signin";
			}
		}
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/user/signup", method = RequestMethod.POST)
	public String signupUser(@ModelAttribute User user, Model model, BindingResult result) {
	    if (result.hasErrors()) {
	        return "auth/signin";
	      }
		if(user != null){
			User dn = userRepo.getDisplayName(user.getDisplayName());
			if(dn == null){
				userRepo.save(user);
				logger.info("Congrats, you Successfully signed up!");
				return "redirect:/signin";
			}
			else{
				model.addAttribute("status", "Fail");
				logger.info("Display name :"+dn.getDisplayName());
				logger.info("User Already Exist!!");
				//return "jsp/signup";
			}
		}
		return "redirect:/signup";
	}
	
	@RequestMapping(value="/aboutus", method = RequestMethod.GET)
	public String aboutUs(Model model){
		return "jsp/AboutUs";
	}

	@RequestMapping(value="/privacy", method = RequestMethod.GET)
	public String privacy(Model model){
		return "redirect:/home";
	}
	
	@RequestMapping(value="/terms", method = RequestMethod.GET)
	public String terms(Model model){
		return "redirect:/home";
	}
	
}
