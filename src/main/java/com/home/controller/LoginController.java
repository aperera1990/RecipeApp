package com.home.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.home.dao.LoginDaoImpl;
import com.home.dto.LoginCredentials;
import com.home.dto.User;

/**
 * Handles requests for the application home page.
 */
@SessionAttributes({ "user" })
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	
	@Autowired
    private Validator validator;
	
	public void setValidator(Validator validator) {
        this.validator = validator;
    }
    
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/logInScreen.do", method = RequestMethod.GET)
	public String logInScreen(Locale locale, ModelMap model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		return "logon";
	}

	@RequestMapping(value = "/logIn.do", method = RequestMethod.POST)
	public ModelAndView logIn(ModelMap model,
			@ModelAttribute("login") LoginCredentials login, 
			BindingResult result) {

		LoginDaoImpl userDaoImpl = new LoginDaoImpl();
		User user = userDaoImpl.getLogon(login.getUsername());
		if (user.getPassword().equals(login.getPassword())) {
			user.setLoggedIn(true);
			return new ModelAndView("success", "user", user);
		} else

			return new ModelAndView("logInScreen.do", null, null);
	}

	@RequestMapping(value = "/logOut.do", method = RequestMethod.GET)
	public String LogOut(ModelMap model, @ModelAttribute("user") User user) {

		return "logOut";
	}

}
