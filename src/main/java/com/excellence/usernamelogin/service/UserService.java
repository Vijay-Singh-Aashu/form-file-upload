package com.excellence.usernamelogin.service;

import org.springframework.stereotype.Service;

import com.excellence.usernamelogin.entity.User;

@Service
public class UserService {

	public boolean authenticateUser(User user) {
		String validUsername = "vijay";
		String validPassword = "vijay@123";
		return validUsername.equals(user.getName()) && validPassword.equals(user.getPass());
	}
}
