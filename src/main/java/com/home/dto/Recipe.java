package com.home.dto;

import java.util.List;

import javax.persistence.*;

public class Recipe {
	public int recipeID;
	public String name;
	public String description;	
	public String imageUrl;
	public List<Ingredient> listOfIngrediants;
	public List<Instruction> listOfInstructions;
	
	public int getRecipeID(){
		return recipeID;
	}
	public void setRecipeId(int recipeID){
		this.recipeID = recipeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Ingredient> getListOfIngrediants() {
		return listOfIngrediants;
	}
	public void setListOfIngrediants(List<Ingredient> listOfIngrediants) {
		this.listOfIngrediants = listOfIngrediants;
	}
	public List<Instruction> getListOfInstructions() {
		return listOfInstructions;
	}
	public void setListOfInstructions(List<Instruction> listOfInstructions) {
		this.listOfInstructions = listOfInstructions;
	}
	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	

}
