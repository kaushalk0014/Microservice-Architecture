package com.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.entity.BankAccount;

@Repository
public interface BankAccountRepositry extends JpaRepository<BankAccount, Long> {

	@Query("select b.accountNumber from BankAccount b where b.accountId="
			+ " (select MAX(ba.accountId) from BankAccount ba)")
	String findLastAccountNumber();

}
