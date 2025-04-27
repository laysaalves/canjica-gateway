package dev.layseiras.canjicagateway.service;

import dev.layseiras.canjicagateway.dtos.PaymentDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducerService {
    private final KafkaTemplate<String, PaymentDTO> kafkaTemplate;

    public PaymentProducerService(KafkaTemplate<String, PaymentDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${topic.name.payment-pending:payment-pending}")
    private String paymentPendingTopic;

    public void sendPayment(PaymentDTO paymentDTO) {
        kafkaTemplate.send(paymentPendingTopic, paymentDTO);
        System.out.println("Sent payment: " + paymentPendingTopic);
    }
}
