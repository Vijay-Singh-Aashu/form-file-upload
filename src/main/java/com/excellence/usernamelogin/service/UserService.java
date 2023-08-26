package com.excellence.usernamelogin.service;

import org.springframework.stereotype.Service;

import com.excellence.usernamelogin.entity.User;

@Service
public class UserService {

	public boolean authenticateUser(User user) {
		String validUsername = "user123";
		String validPassword = "password123";
		return validUsername.equals(user.getUsername()) && validPassword.equals(user.getPassword());
	}
}
