package edu.miu.lab.controller;

import edu.miu.lab.domain.Account;
import edu.miu.lab.exception.AccountNotFoundException;
import edu.miu.lab.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/accounts")
    public ResponseEntity<?> createAccount(@RequestBody @Valid Account account) {
        this.bankService.createAccount(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @DeleteMapping("/accounts/{accountNumber}")
    public ResponseEntity<?> removeAccount(@PathVariable("accountNumber") String accountNumber) {
        this.bankService.removeAccount(accountNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/accounts/{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable("accountNumber") String accountNumber) {
        Account account = this.bankService.getAccount(accountNumber);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping("/accounts/deposit")
    public ResponseEntity<?> deposit(String accountNumber, Double amount) throws AccountNotFoundException {
        Account account = this.bankService.getAccount(accountNumber);
        if (account == null)
            throw new AccountNotFoundException("Account with account no. " + accountNumber + " not found");
        this.bankService.deposit(accountNumber, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/accounts/withdraw")
    public ResponseEntity<?> withdraw(String accountNumber, Double amount) throws AccountNotFoundException {
        Account account = this.bankService.getAccount(accountNumber);
        if (account == null)
            throw new AccountNotFoundException("Account with account no. " + accountNumber + " not found");
        this.bankService.withdraw(accountNumber, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
