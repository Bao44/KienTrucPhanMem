package vn.edu.iuh.fit.shippingservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shipments")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;
    private String status; // PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELLED

    @Column(columnDefinition = "TEXT")
    private String address;

    @Column(unique = true)
    private String trackingNumber;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime estimatedDeliveryDate;
    private String carrier;
}
