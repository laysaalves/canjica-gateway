package dev.layseiras.canjicagateway.controllers;

import dev.layseiras.canjicagateway.entities.Account;
import dev.layseiras.canjicagateway.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class AccountController {
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public Account addNewAccount (@RequestBody Account account) {
        return service.addNewAccount(account);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return service.getAllAccounts();
    }
}
