package com.excellence.usernamelogin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String accountNumber;

	private String bankName;

//	private String date;

	private String naration;

	private String valueDate;

	private String debitAmount;

//	private String creditAmount;

	private String cheque;

	private String closingBalance;

	public Bank(String naration, String valuedate, String debitamount, String cheque, String closingbalance) {
		super();

//		this.date = date;
		this.naration = naration;
		this.valueDate = valuedate;
		this.debitAmount = debitamount;
//		this.creditAmount = creditamount;
		this.cheque = cheque;
		this.closingBalance = closingbalance;
	}

}
