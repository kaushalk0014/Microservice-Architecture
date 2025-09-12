package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.bank.dao")
@EntityScan(basePackages = "com.bank.entity")
public class BankServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServiceApiApplication.class, args);
	}

}
