package edu.miu.lab.service;

import edu.miu.lab.data.BankRepository;
import edu.miu.lab.domain.Account;
import edu.miu.lab.domain.Transaction;
import edu.miu.lab.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public Account createAccount(Account account) {
        this.bankRepository.save(account);
        return this.bankRepository.findByAccountNumber(account.getAccountNumber());
    }

    public void removeAccount(String accountNumber) {
        Account account = this.bankRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account with account no. " + accountNumber + " not found");
        }
        this.bankRepository.delete(accountNumber);
    }

    public Account getAccount(String accountNumber) {
        Account account = this.bankRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account with account no. " + accountNumber + " not found");
        }
        return account;
    }

    public void deposit(String accountNumber, double amount) {
        Transaction transaction = new Transaction(amount, new Date());
        Account account = this.getAccount(accountNumber);
        account.addTransactions(transaction);
        this.bankRepository.save(account);
    }

    public void withdraw(String accountNumber, double amount) {
        Transaction transaction = new Transaction(-amount, new Date());
        Account account = this.getAccount(accountNumber);
        account.addTransactions(transaction);
        this.bankRepository.save(account);
    }
}
