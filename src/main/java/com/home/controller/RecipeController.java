package com.home.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.home.dto.Instruction;
import com.home.dto.Recipe;
import com.home.dto.Ingredient;
import com.home.dto.User;
import com.home.service.RecipeService;

/**
 * Handles requests for the application home page.
 */
@SessionAttributes({ "user", "recipe", "instruction" })
@Controller
public class RecipeController {
	
	RecipeService recipeService = new RecipeService();

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/browseRecipe.do", method = RequestMethod.GET)
	public String browseRecipe(ModelMap model, HttpServletRequest request,
			@ModelAttribute("user") User user) {
		
		List<Recipe> listOfRecipes = new ArrayList<Recipe>();
		List<Recipe> featuredRecipes = new ArrayList<Recipe>();

		featuredRecipes = recipeService.getFeaturedRecipes();
		listOfRecipes = recipeService.getRecipeList();

		model.put("featuredRecipes", featuredRecipes);
		model.put("recipes", listOfRecipes);
		request.setAttribute("user", user);

		return "recipeList";
	}

	@RequestMapping(value = "/selectRecipe.do", method = RequestMethod.GET)
	public String selectRecipe(ModelMap model,
			@ModelAttribute("user") User user,
			@RequestParam("recipeID") String id) {

		int recID = Integer.parseInt(id);
		Recipe recipe = recipeService.getRecipeByRecipeID(recID);
		List<Ingredient> listOfIngrediants = recipeService
				.getIngredientsByRecipeId(recID);
		List<Instruction> listOfInstructions = recipeService
				.getInstructionsByRecipeId(recID);

		model.put("ingrediants", listOfIngrediants);
		model.put("instructions", listOfInstructions);
		model.put("recipe", recipe);
		model.put("user", user);

		return "recipeInstructions";
	}

	@RequestMapping(value = "/addRecipe.do", method = RequestMethod.GET)
	public ModelAndView addNewRecipe(ModelMap model, Recipe recipe) {

		return new ModelAndView("addNewRecipe", "command", recipe);

	}

	@RequestMapping(value = "/addIngrediants.do", method = RequestMethod.POST)
	public ModelAndView addIngrediants(ModelMap model,
			@ModelAttribute("recipe") Recipe recipe,
			@ModelAttribute("ingrediant") Ingredient ingredient,
			BindingResult result) {

		if (recipe.getListOfIngrediants() == null) {
			List<Ingredient> listOfIngrediants = new ArrayList<Ingredient>();
			listOfIngrediants.add(ingredient);
			recipe.setListOfIngrediants(listOfIngrediants);
			model.put("ingrediant", new Ingredient());
		} else {
			recipe.getListOfIngrediants().add(ingredient);
			model.put("ingrediant", new Ingredient());
		}
		return new ModelAndView("addIngrediants", "command", recipe);

	}

	@RequestMapping(value = "/insertInstructions.do", method = RequestMethod.GET)
	public ModelAndView insertInstructions(ModelMap model,
			@ModelAttribute("recipe") Recipe recipe, BindingResult result) {

		model.put("instruction", new Instruction());

		return new ModelAndView("addInstructions", "command", recipe);
	}

	@RequestMapping(value = "/addInstructions.do", method = RequestMethod.POST)
	public ModelAndView addInstructions(ModelMap model,
			@ModelAttribute("recipe") Recipe recipe,
			@ModelAttribute("instruction") Instruction instruction,
			BindingResult result) {

		if (recipe.getListOfInstructions() == null) {
			List<Instruction> listOfInstructions = new ArrayList<Instruction>();
			listOfInstructions.add(instruction);
			recipe.setListOfInstructions(listOfInstructions);
		} else {
			recipe.getListOfInstructions().add(instruction);
		}
		model.put("instruction", new Instruction());

		return new ModelAndView("addInstructions", "command", recipe);
	}

	@RequestMapping(value = "/finishRecipe.do", method = RequestMethod.GET)
	public ModelAndView finishRecipe(ModelMap model,
			@ModelAttribute("recipe") Recipe recipe,
			@ModelAttribute("instruction") Instruction instruction,
			BindingResult result) {
		
		recipeService.createNewRecipe(recipe);
		
		
		return new ModelAndView("recipeSuccess", "command", recipe);
	}
}
