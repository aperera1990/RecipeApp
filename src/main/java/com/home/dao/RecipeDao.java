package com.home.dao;

import java.util.List;

import com.home.dto.Ingredient;
import com.home.dto.Instruction;
import com.home.dto.Recipe;

public interface RecipeDao {
	
	public List<Recipe> getAllRecipeNames();
	
	public List<Instruction> getInstructionsForRecipeID(int recipeID);
	
	public List<Ingredient> getIngredientsForRecipeID(int recipeID);
	
	public void createNewRecipeDetails(Recipe recipe);
	
	public int getRecipeIdForNewRecipe(Recipe recipe);
	
	public boolean addIngredientsToRecipe(Ingredient ingredient, int recipeID);
	
	public boolean addInstructionsToRecipe(Instruction instruction, int recipeID);

	public Recipe getRecipeByRecipeID(int recipeID);
	
	public List<Recipe> getThreeRandomRecipes();
	
	
	
	
	
	
}
