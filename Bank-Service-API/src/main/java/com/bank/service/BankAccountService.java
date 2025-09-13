package com.bank.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.BankAccountRepositry;
import com.bank.domain.AccountStatus;
import com.bank.domain.AccountType;
import com.bank.entity.BankAccount;

import jakarta.transaction.Transactional;

@Service
public class BankAccountService {

	private static final Logger logger = LogManager.getLogger(BankAccountService.class);

	@Autowired
	private BankAccountRepositry bankAccountRepositry;

	@Transactional
	public String createAccount(BankAccount bankAccount) {
		logger.info("Create new account, Customer id is : " + bankAccount.getCustomerId());
		bankAccount.setAccountNumber(generateAccountNumber());
		bankAccount.setStatus(AccountStatus.ACTIVE.getStatus());
		bankAccount.setAccountType(bankAccount.getAccountType().equalsIgnoreCase(AccountType.SAVINGS.getAccountType())
				? AccountType.SAVINGS.getAccountType()
				: AccountType.CURRENT.getAccountType());
		bankAccountRepositry.save(bankAccount);
		return "account open successfully " + bankAccount.getAccountNumber();
	}

	private String generateAccountNumber() {
		String accouuntNumber = findMaxAccountNumber();
		if(accouuntNumber==null || accouuntNumber.isEmpty()) {
			accouuntNumber="52050001";
		}
		long number = Long.parseLong(accouuntNumber);
		String newAccountNumber = String.format("%011d", number+1);

		logger.info("Account number generate " + accouuntNumber);
		return newAccountNumber;

	}

	private String findMaxAccountNumber() {
		return bankAccountRepositry.findLastAccountNumber();
	}
	
	

}
