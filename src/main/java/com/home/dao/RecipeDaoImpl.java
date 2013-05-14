package com.home.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.home.dto.Ingredient;
import com.home.dto.Instruction;
import com.home.dto.Recipe;

public class RecipeDaoImpl implements RecipeDao {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/Recipe1";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";

	public List<Recipe> getAllRecipeNames() {

		List<Recipe> listOfRecipes = new ArrayList<Recipe>();
		Connection connection = null;
		CallableStatement stmt = null;
		String insertStoreProc = "{call GetAllRecipes()}";

		try {
			connection = getDbConnection();
			stmt = connection.prepareCall(insertStoreProc);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				Recipe recipe = new Recipe();
				recipe.setRecipeId(rs.getInt("recipe_id"));
				recipe.setName(rs.getString("recipe_name"));
				recipe.setDescription(rs.getString("recipe_desc"));
				listOfRecipes.add(recipe);
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
		return listOfRecipes;

	}

	public Recipe getRecipeByRecipeID(int recipeID) {

		Recipe recipe = new Recipe();
		Connection connection = null;
		CallableStatement stmt = null;
		String insertStoreProc = "{call GetRecipeByID(?)}";

		try {
			connection = getDbConnection();
			stmt = connection.prepareCall(insertStoreProc);
			stmt.setInt(1, recipeID);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				recipe.setRecipeId(rs.getInt("recipe_id"));
				recipe.setName(rs.getString("recipe_name"));
				recipe.setDescription(rs.getString("recipe_desc"));
				recipe.setImageUrl(rs.getString("recipe_picture_url"));
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
		return recipe;

	}


	public List<Instruction> getInstructionsForRecipeID(int recipeID) {
		List<Instruction> listOfInstructions = new ArrayList<Instruction>();
		Connection connection = null;
		CallableStatement stmt = null;
		String storeProcedure = "{call getInstructionsForRecipeID(?)}";

		try {
			connection = getDbConnection();
			stmt = connection.prepareCall(storeProcedure);
			stmt.setInt(1, recipeID);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				Instruction instruction = new Instruction();
				instruction.setInstruction(rs.getString("instruction"));
				listOfInstructions.add(instruction);
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
		return listOfInstructions;

	}

	public List<Ingredient> getIngredientsForRecipeID(int recipeID) {
		List<Ingredient> listOfingredients = new ArrayList<Ingredient>();
		CallableStatement stmt = null;
		Connection connection = null;
		String storeProcedure = "{call getIngredientsForRecipeID(?)}";
		try {
			connection = getDbConnection();
			stmt = connection.prepareCall(storeProcedure);
			stmt.setInt(1, recipeID);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				Ingredient ingredient = new Ingredient();
				ingredient.setIngredientName(rs.getString("ingredient_name"));
				ingredient.setAmount(rs.getString("amount"));
				ingredient.setUnit(rs.getString("unit"));
				listOfingredients.add(ingredient);
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
		return listOfingredients;

	}

	public void createNewRecipeDetails(Recipe recipe) {

		CallableStatement stmt = null;
		Connection connection = null;
		String storedProcedure = "{call createNewRecipe(?,?)}";

		try {
			connection = getDbConnection();
			stmt = connection.prepareCall(storedProcedure);
			stmt.setString(1, recipe.getName());
			stmt.setString(2, recipe.getDescription());
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

	}

	public int getRecipeIdForNewRecipe(Recipe recipe) {

		CallableStatement stmt = null;
		Connection connection = null;
		int newRecipeID = 0;
		String storedProcedure = "{call getRecipeIdByName(?)}";

		try {
			connection = getDbConnection();
			stmt = connection.prepareCall(storedProcedure);
			stmt.setString(1, recipe.getName());
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				newRecipeID = rs.getInt("recipe_id");
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return 0;
		}
		return newRecipeID;
	}

	public boolean addIngredientsToRecipe(Ingredient ingredient, int recipeID) {

		CallableStatement stmt = null;
		Connection connection = null;
		String storeProcedure = "{call addIngredientToRecipe(?,?,?,?)}";
		try {
			connection = getDbConnection();
			stmt = connection.prepareCall(storeProcedure);
			stmt.setString(1, ingredient.getIngredientName());
			stmt.setInt(2, recipeID);
			stmt.setString(3, ingredient.getAmount());
			stmt.setString(4, ingredient.getUnit());
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean addInstructionsToRecipe(Instruction instruction, int recipeID) {

		CallableStatement stmt = null;
		Connection connection = null;
		String storeProcedure = "{call addInstructionsToRecipe(?,?)}";
		try {
			connection = getDbConnection();
			stmt = connection.prepareCall(storeProcedure);
			stmt.setString(1, instruction.getInstruction());
			stmt.setInt(2, recipeID);
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Connection getDbConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	public List<Recipe> getThreeRandomRecipes() {

		CallableStatement stmt = null;
		Connection connection = null;
		List<Recipe> featureRecipes = new ArrayList<Recipe>();
		String storeProcedure = "{call getThreeRandomRecipes()}";
		try {
			connection = getDbConnection();
			stmt = connection.prepareCall(storeProcedure);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				Recipe recipe = new Recipe();
				recipe.setRecipeId(rs.getInt("recipe_id"));
				recipe.setName(rs.getString("recipe_name"));
				recipe.setDescription(rs.getString("recipe_desc"));
				recipe.setImageUrl(rs.getString("recipe_picture_url"));
				featureRecipes.add(recipe);
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return featureRecipes;
		}
		return featureRecipes;
	}

}
