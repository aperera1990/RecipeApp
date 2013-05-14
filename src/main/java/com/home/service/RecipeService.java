package com.home.service;

import java.util.ArrayList;
import java.util.List;

import com.home.dao.RecipeDao;
import com.home.dao.RecipeDaoImpl;
import com.home.dto.Ingredient;
import com.home.dto.Instruction;
import com.home.dto.Recipe;

public class RecipeService {
	
	RecipeDao recipeDao = new RecipeDaoImpl();

	public List<Recipe> getRecipeList(){
		
		List<Recipe> recipeList = new ArrayList<Recipe>();
		recipeList = recipeDao.getAllRecipeNames();
		
		return recipeList;
	}
	
	public Recipe getRecipeByRecipeID(int recipeId){
		
		Recipe recipe = new Recipe();		
		recipe = recipeDao.getRecipeByRecipeID(recipeId);
		
		return recipe;
	}
	
	public List<Ingredient> getIngredientsByRecipeId(int recipeId){
		
		List<Ingredient> listOfIngrediants = new ArrayList<Ingredient>();
		listOfIngrediants = recipeDao.getIngredientsForRecipeID(recipeId);
		
		return listOfIngrediants;
	}
	
	public List<Instruction> getInstructionsByRecipeId(int recipeId){
		
		List<Instruction> listOfInstructions = recipeDao.getInstructionsForRecipeID(recipeId);
		
		return listOfInstructions;
		
	}
	
	public void createNewRecipe(Recipe recipe){
		int newRecipeID;
		List<Ingredient> listOfIngredients = recipe.getListOfIngrediants();
		List<Instruction> listOfInstructions = recipe.getListOfInstructions();
		
		recipeDao.createNewRecipeDetails(recipe);
		newRecipeID = recipeDao.getRecipeIdForNewRecipe(recipe);
		
		for(int i = 1; i < listOfIngredients.size(); i++){
			Ingredient ingredient = listOfIngredients.get(i);
			recipeDao.addIngredientsToRecipe(ingredient, newRecipeID);
		}
		for(int j = 0; j < listOfInstructions.size(); j++){
			Instruction instruction = listOfInstructions.get(j);
			recipeDao.addInstructionsToRecipe(instruction, newRecipeID);
		}
		
		
	}
	public List<Recipe> getFeaturedRecipes(){
		List<Recipe> featuredRecipes = new ArrayList<Recipe>();
		featuredRecipes = recipeDao.getThreeRandomRecipes();
	
		
		return featuredRecipes;
	}
}
