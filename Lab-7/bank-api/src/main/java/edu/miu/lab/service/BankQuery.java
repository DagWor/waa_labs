package edu.miu.lab.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import edu.miu.lab.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankQuery implements GraphQLQueryResolver {
    @Autowired
    private BankService bankService;

    public Account account(String accountNumber) {
        return bankService.getAccount(accountNumber);
    }
}
