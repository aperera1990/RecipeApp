package com.home.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.home.dao.CookBookDao;
import com.home.dao.CookBookDaoImpl;
import com.home.dao.RecipeDao;
import com.home.dao.RecipeDaoImpl;
import com.home.dto.Recipe;
import com.home.dto.User;

/**
 * Handles requests for the application home page.
 */

@SessionAttributes({"user"})
@Controller
public class CookBookController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/viewCookBook.do", method = RequestMethod.GET)
	public String viewCookBook(Locale locale, ModelMap model, @ModelAttribute("user") User user) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		List<Recipe> listOfRecipeIds = new ArrayList<Recipe>();
		List<Recipe> listOfRecipes = new ArrayList<Recipe>();
		CookBookDao cookBookDao = new CookBookDaoImpl();
		RecipeDao recipeDao = new RecipeDaoImpl();
		listOfRecipeIds = cookBookDao.getUserRecipesByUserID(user.getUserID());
		for (int i = 0; i < listOfRecipeIds.size(); i++) {
			Recipe recipe = new Recipe();
			recipe = recipeDao.getRecipeByRecipeID(listOfRecipeIds.get(i)
					.getRecipeID());
			listOfRecipes.add(recipe);
		}
		model.put("recipes", listOfRecipes);
		model.put("user", user);
		

		return "cookBook";
	}
}
