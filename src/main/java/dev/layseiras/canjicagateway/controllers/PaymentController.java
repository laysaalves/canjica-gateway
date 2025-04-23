package dev.layseiras.canjicagateway.controllers;

import dev.layseiras.canjicagateway.entities.Account;
import dev.layseiras.canjicagateway.entities.Payment;
import dev.layseiras.canjicagateway.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pay")
public class PaymentController {
    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public Payment generatePayment(@RequestBody Payment payment) {
        return service.generatePayment(payment);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return service.getAllPayments();
    }

    @GetMapping("/{email}")
    public List<Account> getPaymentByClient(@PathVariable String email) {
        return service.getPaymentByClient(email);
    }
}
