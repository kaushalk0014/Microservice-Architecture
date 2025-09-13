package com.customer.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.entiry.Customer;

@Repository
public interface CustomerReposirty extends JpaRepository<Customer, Long>{

}
