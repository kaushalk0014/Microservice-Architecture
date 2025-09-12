package com.customer.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entiry.Customer;
import com.customer.repositry.CustomerReposirty;

@Service
public class CustomerService {

	private static final Logger logger = LogManager.getLogger(CustomerService.class);
	
	@Autowired
	private CustomerReposirty customerReposirty;
	
	public String openAccount(Customer customer) {
		customer = customerReposirty.save(customer);
		logger.info("account open successfully "+customer.getCustomerId());
		return "account open successfully ";
	}

}
