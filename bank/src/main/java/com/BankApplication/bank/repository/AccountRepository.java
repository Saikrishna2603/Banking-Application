package com.BankApplication.bank.repository;

import com.BankApplication.bank.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


//AccountRepository interface extends JpaRepository then it will get the CRUD methods to perform
// CRUD database operations on Account entity.
public interface AccountRepository extends JpaRepository<Account,Long> {
}
