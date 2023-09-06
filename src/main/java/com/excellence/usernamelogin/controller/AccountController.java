package com.excellence.usernamelogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excellence.usernamelogin.entity.Account;
import com.excellence.usernamelogin.service.AccountService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @GetMapping("/{accountNumber}")
    public Account getAccountDetails(@PathVariable String accountNumber) {
        return accountService.getAccountByAccountNumber(accountNumber);
    }
}

