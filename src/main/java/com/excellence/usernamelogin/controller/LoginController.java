package com.excellence.usernamelogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excellence.usernamelogin.entity.User;
import com.excellence.usernamelogin.response.ResponseMessage;
import com.excellence.usernamelogin.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class LoginController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<ResponseMessage> login(@RequestBody User user) {
		if (userService.authenticateUser(user)) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Login Successful!"));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseMessage("Login failed!"));
		}
	}
}
