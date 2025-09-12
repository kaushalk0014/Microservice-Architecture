package com.customer.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entiry.Customer;

public interface CustomerReposirty extends JpaRepository<Customer, Long>{

}
