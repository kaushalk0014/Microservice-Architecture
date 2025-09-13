package com.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.event.CustomerCreatedSuccess;
import com.customer.event.CustomerEvent;

import reactor.core.publisher.Sinks;

@Service
public class CustomerServicePublisher {

	@Autowired
	private Sinks.Many<CustomerEvent> customerSinks;
	
	
	public void publisCustomerEvent(CustomerCreatedSuccess customerCreatedSuccess) {
		CustomerEvent  customerEvent = new CustomerEvent(customerCreatedSuccess);
		customerSinks.tryEmitNext(customerEvent);
	}
}
