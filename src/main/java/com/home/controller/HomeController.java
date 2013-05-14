package com.home.controller;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import com.home.dto.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, ModelMap model, HttpServletRequest request, User user) {
		logger.info("This is the home controller, Localeis :", locale);
		
		request.setAttribute("user", user);
		model.addAttribute("loggedIn", user.isLoggedIn());
		return new ModelAndView("index", "command", user);
	}
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String backToHome(Locale locale, Model model, @ModelAttribute("user") User user) {
		logger.info("This is the home controller, Localeis :", locale);
		model.addAttribute("user", user);
		model.addAttribute("loggedIn", user.isLoggedIn());
		return "index";
	}
}
