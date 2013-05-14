package com.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.home.dao.RecipeDao;
import com.home.dao.RecipeDaoImpl;
import com.home.dto.Recipe;

public class RecipeDaoTest {
	
	RecipeDao recipeDao = new RecipeDaoImpl();

	@Test
	public void test() {
		
		List<Recipe> listOfRecipes = new ArrayList<Recipe>();
		
		listOfRecipes = recipeDao.getThreeRandomRecipes();
		
		assertNotNull(null, listOfRecipes);
		
	}

}
