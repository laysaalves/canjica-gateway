package dev.layseiras.canjicagateway.service;

import dev.layseiras.canjicagateway.entities.Account;
import dev.layseiras.canjicagateway.entities.Payment;
import dev.layseiras.canjicagateway.repositories.AccountRepository;
import dev.layseiras.canjicagateway.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository repository;

    private final AccountRepository accountRepo;

    public PaymentService(PaymentRepository repository, AccountRepository accountRepo) {
        this.repository = repository;
        this.accountRepo = accountRepo;
    }

    public Payment generatePayment(Payment payment) {
        return repository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    public List<Account> getPaymentByClient(String email) {
        return accountRepo.findByEmail(email);
    }
}
