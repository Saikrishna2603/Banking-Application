package com.BankApplication.bank.Controller;

import com.BankApplication.bank.Entity.Account;
import com.BankApplication.bank.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController
{
    @Autowired
    private AccountService accService;

    @PostMapping
    public Account createAccount(@RequestBody Account acc)
    {
        return accService.CreateAccount(acc);
    }
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id)
    {
        return accService.getAccount(id).orElseThrow(()->new RuntimeException("Account NotFound"));
    }
    //REST Api For depsoit
    @PostMapping("/{id}/deposit")
    public Account deposit(@RequestBody Map<String,Double> reqBody, @PathVariable Long id)
    {
        Double amount=reqBody.get("amount");
        return accService.deposit(id,amount);
    }
    // Rest ApI for Withdraw
    @PostMapping("{id}/withdraw")
    public Account withDraw(@RequestBody Map<String,Double> reqBody,@PathVariable Long id)
    {
        Double amount=reqBody.get("amount");
        return accService.withdraw(id,amount);
    }

}
