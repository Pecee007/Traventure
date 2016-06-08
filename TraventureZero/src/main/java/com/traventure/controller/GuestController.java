package com.traventure.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.traventure.domain.User;
import com.traventure.domain.userAuth;

@Controller
public class GuestController {
		
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/signin.htm", method = RequestMethod.GET)
	public String signin(/*@RequestParam("username")String username, 
			@RequestParam("password")String password, */Model model) {
		return "jsp/signin";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup(@ModelAttribute User user, Model model) {
		
			List<String> genderList = new ArrayList<String>();
			genderList.add("male");
			genderList.add("female");

			List<String> ageList = new ArrayList<String>();
			ageList.add("15-20");
			ageList.add("21-25");
			ageList.add("26-35");
			ageList.add("36-50");
			ageList.add("51-65");
			ageList.add("66-above");
			
			List<String> locationList = new ArrayList<String>();
			locationList.add("Bangalore");
			locationList.add("Mumbai");
			locationList.add("Chennai");
			locationList.add("Kolkata");
			locationList.add("Delhi");
			locationList.add("Gurgaon");
			locationList.add("Meerut");
			locationList.add("Noida");

			Map<String, List> map = new HashMap<String, List>();
			map.put("genderList", genderList);
			map.put("locationList", locationList);
			map.put("ageList", ageList);
			return new ModelAndView("jsp/signup", "map", map);
			
	}
	
		
	@RequestMapping(value="/aboutus.htm", method = RequestMethod.GET)
	public String aboutUs(Model model){
		return "jsp/AboutUs";
	}
	
	@RequestMapping(value="/FAQs.htm", method = RequestMethod.GET)
	public String faq(Model model){
		return "jsp/FAQs";
	}

	@RequestMapping(value="/privacy.htm", method = RequestMethod.GET)
	public String privacy(Model model){
		return "redirect:/home.htm";
	}
	
	@RequestMapping(value="/terms.htm", method = RequestMethod.GET)
	public String terms(Model model){
		return "redirect:/home.htm";
	}
	
	@RequestMapping(value="/hotelDesc.htm", method = RequestMethod.GET)
	public String desc(Model model){
		return "jsp/hoteldesc";
	}

}
