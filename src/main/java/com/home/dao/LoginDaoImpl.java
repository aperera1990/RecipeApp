package com.home.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.home.dto.User;

public class LoginDaoImpl implements LoginDao{
	
public User getLogon(String userName){
		
		User user = new User();

				String query = "SELECT * FROM user WHERE username LIKE '%"
						+ userName + "%'";
				Statement stmt = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					return null;
				}
				Connection connection = null;
				try {
					connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/Recipe1", "root", "");
					stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {	
						user.setUserID(rs.getInt("user_id"));
						user.setName(rs.getString("name"));
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						
					}
				} catch (SQLException e) {
					System.out.println("Connection Failed! Check output console");
					e.printStackTrace();
					return null;
				}
				return user;

			}

}
