package edu.miu.lab.data;

import edu.miu.lab.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends MongoRepository<Account, String> {
    Account findByAccountNumber(String accountNumber);
}