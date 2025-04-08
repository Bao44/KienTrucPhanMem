package vn.edu.iuh.fit.paymentservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.paymentservice.models.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByOrderId(String orderId);
    Optional<Payment> findByTransactionId(String transactionId);
}
