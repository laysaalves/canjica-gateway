package dev.layseiras.canjicagateway.service;

import dev.layseiras.canjicagateway.dtos.PaymentDTO;
import dev.layseiras.canjicagateway.entities.Payment;
import dev.layseiras.canjicagateway.mappers.PaymentMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducerService {

    private final KafkaTemplate<String, PaymentDTO> kafkaTemplate;
    private final PaymentMapper paymentMapper;

    @Value("${topic.name.payment-pending:payment-pending}")
    private String paymentPendingTopic;

    public PaymentProducerService(KafkaTemplate<String, PaymentDTO> kafkaTemplate, PaymentMapper paymentMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.paymentMapper = paymentMapper;
    }

    public void sendPayment(Payment payment) {
        PaymentDTO dto = paymentMapper.toPaymentDTO(payment);
        kafkaTemplate.send(paymentPendingTopic, dto);
    }
}
