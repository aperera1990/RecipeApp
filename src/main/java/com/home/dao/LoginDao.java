package com.home.dao;

import com.home.dto.User;

public interface LoginDao {
	
	public User getLogon(String userName);
	
}
