package dev.layseiras.canjicagateway.service;

import dev.layseiras.canjicagateway.entities.Account;
import dev.layseiras.canjicagateway.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account addNewAccount(Account account) {
        return repository.save(account);
    }

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }
}
