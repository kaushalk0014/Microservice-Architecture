package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entiry.Customer;
import com.customer.service.CustomerService;

@RestController
@RequestMapping("customer/api/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("open/account")
	public ResponseEntity<String> openAccount(@RequestBody Customer customer){
		String data = customerService.openAccount(customer);
		return ResponseEntity.ok(data);
	}
}
