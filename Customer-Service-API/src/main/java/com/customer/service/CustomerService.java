package com.customer.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.domain.CustomerStatus;
import com.customer.entiry.Customer;
import com.customer.event.CustomerCreatedSuccess;
import com.customer.repositry.CustomerReposirty;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {

	private static final Logger logger = LogManager.getLogger(CustomerService.class);
	
	@Autowired
	private CustomerReposirty customerReposirty;
	
	@Autowired
	private CustomerServicePublisher customerServicePublisher;
	
	@Transactional
	public String openAccount(Customer customer) {
		customer.setStatus(CustomerStatus.ACTIVE.getStatus());
		customer = customerReposirty.save(customer);
		
		
		
		logger.info("account open successfully "+customer.getCustomerId());
		
		//produce kafka event with status customer create
		CustomerCreatedSuccess customerEvent= new CustomerCreatedSuccess();
		customerEvent.setCustomerId(customer.getCustomerId());
		customerEvent.setStatus("CUSTOMER-CREATED-SUCCESSFYLLY");
		customerEvent.setStatus("Welcome to the new customer");
		customerServicePublisher.publisCustomerEvent(customerEvent);
		return "account open successfully";
	}

}
