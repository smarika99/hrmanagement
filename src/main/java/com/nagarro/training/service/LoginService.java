package com.nagarro.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.dao.LoginDao;
import com.nagarro.training.dto.User;


@Service
public class LoginService {
	@Autowired
	private LoginDao logindao;

	public Boolean loginAuthentication(String username, String password) {
		User user = logindao.getUserDetails(username);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	public Boolean usernameVerify(String username) {
		User user = logindao.getUserDetails(username);
		return user == null ? true : false;
	}

	public Boolean usernameAndPhoneVerify(String username, String phone) {
		User user = logindao.getUserDetails(username);
		if (user != null && user.getPhone().equals(phone)) {
			return true;
		}
		return false;
	}

	public void signUp(String username, String password, String phone) {
		User user = new User();
		user.setPassword(password);
		user.setPhone(phone);
		user.setUsername(username);
		logindao.signup(user);
	}

	public void forgetPassword(String username, String password) {
		logindao.updatePassword(username, password);
	}
}
