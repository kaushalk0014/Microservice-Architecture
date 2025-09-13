package com.bank.domain;

public enum AccountStatus {
	ACTIVE("Active"), CLOSED("Closed");

	private final String status;

	AccountStatus(String code) {
		this.status = code;
	}

	public String getStatus() {
		return status;
	}

}
