package vn.edu.iuh.fit.shippingservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.shippingservice.models.Shipment;

import java.util.List;
import java.util.Optional;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    List<Shipment> findByOrderId(String orderId);
    Optional<Shipment> findByTrackingNumber(String trackingNumber);
}