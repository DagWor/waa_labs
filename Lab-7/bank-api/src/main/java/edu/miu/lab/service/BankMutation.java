package edu.miu.lab.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import edu.miu.lab.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankMutation implements GraphQLMutationResolver {
    @Autowired
    private BankService bankService;

    public Account createAccount(String accountNumber, String accountHolder, double balance) {
        Account account = new Account(accountNumber, accountHolder, balance);
        return bankService.createAccount(account);
    }

    public void deposit(String accountNumber, double amount) {
        bankService.deposit(accountNumber, amount);
    }

    public void withdraw(String accountNumber, double amount) {
        bankService.withdraw(accountNumber, amount);

    }
}
