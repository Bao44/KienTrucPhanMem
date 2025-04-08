package vn.edu.iuh.fit.paymentservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.paymentservice.models.Payment;
import vn.edu.iuh.fit.paymentservice.repositories.PaymentRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(String orderId, BigDecimal amount, String paymentMethod) {
        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setAmount(amount);
        payment.setPaymentMethod(paymentMethod);
        payment.setStatus("PENDING");
        payment.setCreatedAt(LocalDateTime.now());
        payment.setUpdatedAt(LocalDateTime.now());
        payment.setTransactionId(UUID.randomUUID().toString());

        boolean paymentSuccessful = simulatePaymentProcessing(amount);

        if (paymentSuccessful) {
            payment.setStatus("COMPLETED");
        } else {
            payment.setStatus("FAILED");
        }

        return paymentRepository.save(payment);
    }

    private boolean simulatePaymentProcessing(BigDecimal amount) {
        return Math.random() > 0.1;
    }

    public Payment refundPayment(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        if (!"COMPLETED".equals(payment.getStatus())) {
            throw new RuntimeException("Only completed payments can be refunded");
        }

        payment.setStatus("REFUNDED");
        payment.setUpdatedAt(LocalDateTime.now());

        return paymentRepository.save(payment);
    }

    public List<Payment> getPaymentsByOrderId(String orderId) {
        return paymentRepository.findByOrderId(orderId);
    }
}
