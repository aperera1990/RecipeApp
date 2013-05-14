package com.home.dao;

import java.util.List;

import com.home.dto.Recipe;

public interface CookBookDao {
	
	public List<Recipe> getUserRecipesByUserID(int userID);
	

}
