package com.customer.domain;

public enum CustomerStatus {
	
	ACTIVE("Active"),
	CLOSED("Closed");
	
	private final String status;
	
	CustomerStatus(String status){
		this.status=status;
	}
	
	public String getStatus() {
		return status;
	}
}
