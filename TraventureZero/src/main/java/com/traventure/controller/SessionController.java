package com.traventure.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.traventure.domain.User;
import com.traventure.domain.userAuth;
import com.traventure.mongoRepository.UserSignUpRepo;

@Controller
@SessionAttributes({"currentUser"})
@RequestMapping(value = "/user")
//@Scope("session")
public class SessionController {
	
	@ModelAttribute("currentUser")
    public userAuth initializeCurrentUser() {
		userAuth currentUser = new userAuth();
        return currentUser;
    }

	@Autowired
	UserSignUpRepo userRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView signinUser(@ModelAttribute("currentUser") userAuth currentUser, @RequestParam("username")String username, 
			@RequestParam("password")String password, Model model) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		//check if the user is valid, if it is GUEST, then redirect to signin page
		//not working as expected, it does not allow signin of user after logout
/*		String currUserRes = (String) currentUser.getResult();
		if(currentUser.getStatus().equals("GUEST")&&currUserRes!=null){
			if(currUserRes.equals("LOGGED_OUT")){
				System.out.println("Here");
				System.out.println(username);
				modelAndView.setViewName("redirect:/signin.htm");
				return modelAndView;
			}
		}
*/
				

		logger.info("You are trying to signin");
		User usr = userRepo.getUser(username);
		//user displayname
		String usrdn = usr.getDisplayName();
		if(usrdn == null){
			logger.info("Username does not exist!");
			modelAndView.setViewName("redirect:/signin");
			return modelAndView;
			//return "redirect:/signin";
		}
		else{ 
			String upwd = usr.getPassword();
			if(upwd.equals(password)){
				//Success Authentication!
				//model.addAttribute("username",usr.getDisplayName());
				//userAuth currentUser = new userAuth();
				currentUser.setStatus("SUCCESS");
				currentUser.setResult(usrdn);
				modelAndView.addObject("currentUser",currentUser);
				String userLocation = usr.getLocation();
				System.out.println(usr.getLocation());
				modelAndView.addObject("userLocation",userLocation);
				System.out.println("Siginin: "+currentUser.getResult());
				logger.info("Successfully signed in!");
				//model.addAttribute("username", usr.getUserName());
			}
			else{
				model.addAttribute("status", "Fail");
				logger.info("Username and  password does not match!!");
				modelAndView.setViewName("redirect:/signin");
				return modelAndView;
				//return "redirect:/signin";
			}
		}
		//if successfully logged in.
		modelAndView.setViewName("jsp/user/homepage");
		return modelAndView;
		//return "jsp/user/homepage";
		//return "redirect:/home";
	}
	
	@RequestMapping(value = "/signup.htm", method = RequestMethod.POST)
	public String signupUser(@ModelAttribute User user, Model model, BindingResult result) {
	    if (result.hasErrors()) {
	        return "auth/signin";
	      }
		if(user != null){
			User dn = userRepo.getUser(user.getDisplayName());
			if(dn == null){
				userRepo.save(user);
				logger.info("Congrats, you Successfully signed up!");
				return "redirect:/signin.htm";
			}
			else{
				model.addAttribute("status", "Fail");
				logger.info("Display name :"+dn);
				logger.info("User Already Exist!!");
				//return "jsp/signup";
			}
		}
		return "redirect:/signup.htm";
	}
	
	@RequestMapping(value="/aboutus.htm", method = RequestMethod.GET)
	public String aboutUs(@ModelAttribute("currentUser") userAuth currentUser, Model model){
		//check if the user is valid, if it is GUEST, then redirect to signin page
		if(currentUser.getStatus().equals("GUEST")){
			return "redirect:/signin.htm";
		}
/*		ModelAndView modelAndView = new ModelAndView();
		if(!user.getResult().equals("GUEST")){
			userAuth ua = new userAuth();
			ua.setStatus("SUCCESS");
			modelAndView.addObject("currentUser", ua);
			logger.info("Successfully signed in!");
			modelAndView.setViewName("jsp/user/AboutUs");
			return modelAndView;
		}
		else if(!user.getResult().equals(null)){
			modelAndView.addObject("currentUser",null);
			modelAndView.setViewName("jsp/signin");
			return modelAndView;
		}
		return modelAndView;*/
		return "jsp/user/AboutUs";
	}
	
	@RequestMapping(value="/FAQs.htm", method = RequestMethod.GET)
	public String faq(@ModelAttribute("currentUser") userAuth currentUser, Model model){
		System.out.println(currentUser.getStatus());
		if(currentUser.getStatus().equals("GUEST")){
			return "redirect:/signin.htm";
		}
		System.out.println("Current user:= " + currentUser.getStatus());
		System.out.println("Current user:= " + currentUser.getResult());
		
		return "jsp/user/FAQs";
	}

	@RequestMapping(value="/privacy.htm", method = RequestMethod.GET)
	public String privacy(@ModelAttribute("currentUser") userAuth currentUser, Model model){
		if(currentUser.getStatus().equals("GUEST")){
			return "redirect:/signin.htm";
		}
		return "redirect:/user/home.htm";
	}
	
	@RequestMapping(value="/terms.htm", method = RequestMethod.GET)
	public String terms(@ModelAttribute("currentUser") userAuth currentUser, Model model){
		if(currentUser.getStatus().equals("GUEST")){
			return "redirect:/signin.htm";
		}
		return "redirect:/user/home.htm";
	}
	
	@RequestMapping(value="/hotelDesc.htm", method = RequestMethod.GET)
	public String desc(@ModelAttribute("currentUser") userAuth currentUser, Model model){
		if(currentUser.getStatus().equals("GUEST")){
			return "redirect:/signin.htm";
		}
		return "jsp/user/hoteldesc";
	}

	@RequestMapping(value="/home.htm", method = RequestMethod.GET)
	public String userhome(@ModelAttribute("currentUser") userAuth currentUser, Model model){
		if(currentUser.getStatus().equals("GUEST")){
			return "redirect:/signin.htm";
		}
		return "jsp/user/homepage";
	}

	@RequestMapping(value="/logout.htm", method = RequestMethod.GET)
	public String logout(@ModelAttribute("currentUser") userAuth currentUser, Model model){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("You are trying to logout..");

		//userAuth ua = new userAuth();
		currentUser.setStatus("GUEST");
		currentUser.setResult("LOGGED_OUT");
		modelAndView.addObject("currentUser", currentUser);
		System.out.println("You are logged out sucessfully!!");
		return "redirect:/signin.htm";
		//return "redirect:/home.htm";
		//return "jsp/homepage";
	}
}
