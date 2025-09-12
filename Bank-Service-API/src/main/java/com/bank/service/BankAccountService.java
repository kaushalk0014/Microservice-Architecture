package com.bank.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.BankAccountRepositry;
import com.bank.entity.BankAccount;

import jakarta.transaction.Transactional;

@Service
public class BankAccountService {

	private static final Logger logger = LogManager.getLogger(BankAccountService.class);
	
	
	
	@Autowired
	private BankAccountRepositry bankAccountRepositry;

	@Transactional
	public String createAccount(BankAccount bankAccount) {
		logger.info("Create new account, Customer id is : "+bankAccount.getCustomerId());
		bankAccount.setAccountNumber(generateAccountNumber());
		bankAccountRepositry.save(bankAccount);
		return "account open successfully " + bankAccount.getAccountNumber();
	}

	private String generateAccountNumber() {
		String accouuntNumber = findMaxAccountNumber();
		long number = Long.parseLong(accouuntNumber);
		String newAccountNumber = String.format("%011d", number);
		
		logger.info("Account number generate "+ accouuntNumber);
		return newAccountNumber;
		
		
	}

	private String findMaxAccountNumber() {
		return bankAccountRepositry.findLastAccountNumber();
	}

}
