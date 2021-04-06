package com.nagarro.training.dao;

import com.nagarro.training.dto.User;


public interface LoginDao {

	User getUserDetails(String username);

	void updatePassword(String username, String password);

	void signup(User user);
}
