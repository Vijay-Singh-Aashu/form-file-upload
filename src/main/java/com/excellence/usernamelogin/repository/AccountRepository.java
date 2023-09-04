package com.excellence.usernamelogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excellence.usernamelogin.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByAccountNumber(String accountNumber);

	Account save(Account account);
}
