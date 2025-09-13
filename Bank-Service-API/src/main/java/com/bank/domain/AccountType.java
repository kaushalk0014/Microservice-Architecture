package com.bank.domain;

public enum AccountType {
	SAVINGS("Saving"),
	CURRENT("Current");
	
	private final String accountType;
	
	AccountType(String accountType){
		this.accountType=accountType;
	}
	
	public String getAccountType() {
		return accountType;
	}
}
