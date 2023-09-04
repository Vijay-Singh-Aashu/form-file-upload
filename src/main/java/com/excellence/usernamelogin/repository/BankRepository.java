package com.excellence.usernamelogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excellence.usernamelogin.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long>{

}
