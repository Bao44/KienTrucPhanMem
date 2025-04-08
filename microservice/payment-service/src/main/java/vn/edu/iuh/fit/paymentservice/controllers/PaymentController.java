package vn.edu.iuh.fit.paymentservice.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.paymentservice.models.Payment;
import vn.edu.iuh.fit.paymentservice.services.PaymentService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<Payment> processPayment(@RequestBody Map<String, Object> request) {
        String orderId = (String) request.get("orderId");
        BigDecimal amount = new BigDecimal(request.get("amount").toString());
        String paymentMethod = (String) request.get("paymentMethod");

        Payment payment = paymentService.processPayment(orderId, amount, paymentMethod);
        return ResponseEntity.ok(payment);
    }

    @PostMapping("/{paymentId}/refund")
    public ResponseEntity<Payment> refundPayment(@PathVariable Long paymentId) {
        Payment payment = paymentService.refundPayment(paymentId);
        return ResponseEntity.ok(payment);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<Payment>> getPaymentsByOrderId(@PathVariable String orderId) {
        List<Payment> payments = paymentService.getPaymentsByOrderId(orderId);
        return ResponseEntity.ok(payments);
    }
}
