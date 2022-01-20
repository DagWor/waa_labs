package edu.miu.lab.service;

import edu.miu.lab.domain.Account;

public class AccountAdapter {

    public static AccountDTO fromAccountToAccountDTO(Account account) {
        return new AccountDTO(account.getAccountNumber(), account.getAccountHolder(), account.getBalance());
    }

    public static Account fromAccountDTOToAccount(AccountDTO accountDTO) {
        return new Account(accountDTO.getAccountNumber(), accountDTO.getAccountHolder(), accountDTO.getBalance());
    }
}
