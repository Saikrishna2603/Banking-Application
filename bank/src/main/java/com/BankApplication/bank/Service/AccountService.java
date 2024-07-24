package com.BankApplication.bank.Service;

import com.BankApplication.bank.Entity.Account;
import com.BankApplication.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService
{
    @Autowired
    private AccountRepository accRepo;

    public Account CreateAccount(Account acc)
    {
        return (Account) accRepo.save(acc);
    }
    public Optional<Account> getAccount(Long Id)
    {
        return accRepo.findById(Id);
    }
    public Account deposit(Long id,double amount)
    {
        Account acc=getAccount(id).orElseThrow(()->new RuntimeException("Account not found"));
        acc.setBalance(acc.getBalance()+amount);
        return (Account) accRepo.save(acc);
    }
    public Account withdraw(Long Id,double amount)
    {
        Account acc=getAccount(Id).orElseThrow(()->new RuntimeException("Account Not Found"));
        if(acc.getBalance()<amount)
        {
            throw new RuntimeException("insufficent funds");
        }
        acc.setBalance(acc.getBalance()-amount);
        return (Account) accRepo.save(acc);
    }
}
