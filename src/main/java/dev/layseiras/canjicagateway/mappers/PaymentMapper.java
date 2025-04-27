package dev.layseiras.canjicagateway.mappers;

import dev.layseiras.canjicagateway.dtos.PaymentDTO;
import dev.layseiras.canjicagateway.entities.Account;
import dev.layseiras.canjicagateway.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    @Value("${base-url}")
    private String baseUrl;

    public PaymentDTO toPaymentDTO(Payment payment) {
        String url = baseUrl + "/billing/" + payment.getId();
        return new PaymentDTO(
                payment.getId(),
                payment.getClient(),
                payment.getAmount(),
                payment.getMethod(),
                payment.getStatus(),
                payment.getDate(),
                url
        );
    }

    public static Payment toPayment(PaymentDTO dto, Account client) {
        return new Payment(
                dto.getId(),
                client,
                dto.getAmount(),
                dto.getMethod(),
                dto.getStatus(),
                dto.getDate()
        );
    }
}
