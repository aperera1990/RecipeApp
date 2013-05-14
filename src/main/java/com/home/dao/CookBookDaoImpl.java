package com.home.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.home.dto.Recipe;

public class CookBookDaoImpl implements CookBookDao {
	
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/Recipe1";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
	
	public List<Recipe> getUserRecipesByUserID(int userID){
		List<Recipe> listOfRecipes = new ArrayList<Recipe>();
		CallableStatement stmt = null;
		Connection connection = null;
		String storeProcedure = "{call getUserRecipesByUserID(?)}";
		
		try {
			connection = getDbConnection();
			stmt = connection.prepareCall(storeProcedure);
			stmt.setInt(1, userID);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				Recipe recipe = new Recipe();
				recipe.setRecipeId(rs.getInt("recipe_ID"));
				
				listOfRecipes.add(recipe);
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
		return listOfRecipes;
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

}
