package edu.miu.lab.data;

import edu.miu.lab.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BankRepository {
    private final Map<String, Account> accounts = new HashMap<>();

    public void save(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account findByAccountNumber(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void delete(String accountNumber) {
        accounts.remove(accountNumber);
    }

    public Collection<Account> findAll() {
        return accounts.values();
    }
}