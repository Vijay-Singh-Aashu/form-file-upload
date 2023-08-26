package com.excellence.usernamelogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excellence.usernamelogin.entity.User;
import com.excellence.usernamelogin.service.UserService;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/login")
    public String login(@RequestBody User user) {
        if (userService.authenticateUser(user)) {
            return "Login successful!";
        } else {
            return "Login failed!";
        }
    }
}



