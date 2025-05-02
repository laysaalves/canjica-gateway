package dev.layseiras.canjicagateway.service;

import dev.layseiras.canjicagateway.entities.Account;
import dev.layseiras.canjicagateway.entities.Payment;
import dev.layseiras.canjicagateway.entities.PaymentStatus;
import dev.layseiras.canjicagateway.repositories.AccountRepository;
import dev.layseiras.canjicagateway.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository repository;

    private final AccountRepository accountRepo;

    private final PaymentProducerService producer;

    public PaymentService(PaymentRepository repository, AccountRepository accountRepo, PaymentProducerService producer) {
        this.repository = repository;
        this.accountRepo = accountRepo;
        this.producer = producer;
    }

    public Payment generatePayment(Payment payment) {
        payment.setStatus(PaymentStatus.PENDING);
        Payment save = repository.save(payment);
        producer.sendPayment(save);
        return save;
    }

    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    public List<Account> getPaymentByClient(String email) {
        return accountRepo.findByEmail(email);
    }
}
