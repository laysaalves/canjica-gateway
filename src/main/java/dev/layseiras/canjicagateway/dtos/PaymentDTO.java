package dev.layseiras.canjicagateway.dtos;

import dev.layseiras.canjicagateway.entities.Account;
import dev.layseiras.canjicagateway.entities.PaymentMethod;
import dev.layseiras.canjicagateway.entities.PaymentStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

public class PaymentDTO {

    private UUID id;

    private Account client;

    private BigDecimal amount;

    private PaymentMethod method;

    private PaymentStatus status;

    private Timestamp date;

    private String url;

    public PaymentDTO() {
    }

    public PaymentDTO(UUID id, Account client, BigDecimal amount, PaymentMethod method, PaymentStatus status, Timestamp date, String url) {
        this.id = id;
        this.client = client;
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.date = date;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Account getClient() {
        return client;
    }

    public void setClient(Account client) {
        this.client = client;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
