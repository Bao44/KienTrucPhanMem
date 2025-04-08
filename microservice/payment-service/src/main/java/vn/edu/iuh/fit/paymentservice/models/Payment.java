package vn.edu.iuh.fit.paymentservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;
    private BigDecimal amount;
    private String paymentMethod; // CREDIT_CARD, PAYPAL, etc.
    private String status; // PENDING, COMPLETED, FAILED, REFUNDED
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String transactionId; // ID from payment processor
}
