package com.bank.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.BankAccount;
import com.bank.service.BankAccountService;

@RestController
@RequestMapping("bank/api/")
public class BankAccountController {

	private static final Logger logger =  LogManager.getLogger(BankAccountController.class);
	
	@Autowired
	private BankAccountService accountService;
	
	@PostMapping("create/account")
	public ResponseEntity<String> createAccount(@RequestBody BankAccount bankAccount){
		String message = accountService.createAccount(bankAccount);
		
		logger.info(message);
		return ResponseEntity.ok(message);
	}
	
}
