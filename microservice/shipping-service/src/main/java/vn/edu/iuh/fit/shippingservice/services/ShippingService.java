package vn.edu.iuh.fit.shippingservice.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.shippingservice.models.Shipment;
import vn.edu.iuh.fit.shippingservice.repositories.ShipmentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class ShippingService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Transactional
    public Shipment createShipment(String orderId, String address) {
        Shipment shipment = new Shipment();
        shipment.setOrderId(orderId);
        shipment.setAddress(address);
        shipment.setStatus("PENDING");
        shipment.setCreatedAt(LocalDateTime.now());
        shipment.setUpdatedAt(LocalDateTime.now());
        shipment.setEstimatedDeliveryDate(LocalDateTime.now().plusDays(5));
        shipment.setCarrier(selectCarrier());

        // Generate a tracking number
        shipment.setTrackingNumber(generateTrackingNumber());

        return shipmentRepository.save(shipment);
    }

    private String selectCarrier() {
        // In a real app, this would be based on location, weight, etc.
        String[] carriers = {"DHL", "FedEx", "UPS"};
        return carriers[new Random().nextInt(carriers.length)];
    }

    private String generateTrackingNumber() {
        // Mock tracking number generation
        return "TRK" + System.currentTimeMillis() + new Random().nextInt(1000);
    }

    @Transactional
    public Shipment updateShipmentStatus(Long shipmentId, String status) {
        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));

        shipment.setStatus(status);
        shipment.setUpdatedAt(LocalDateTime.now());

        if ("SHIPPED".equals(status)) {
            // If shipment status is changed to shipped, update estimated delivery
            shipment.setEstimatedDeliveryDate(LocalDateTime.now().plusDays(3));
        }

        return shipmentRepository.save(shipment);
    }

    public List<Shipment> getShipmentsByOrderId(String orderId) {
        return shipmentRepository.findByOrderId(orderId);
    }

    public Shipment getShipmentByTrackingNumber(String trackingNumber) {
        return shipmentRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new RuntimeException("Shipment not found with tracking number: " + trackingNumber));
    }

    @Transactional
    public Shipment cancelShipment(Long shipmentId) {
        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));

        if ("SHIPPED".equals(shipment.getStatus()) || "DELIVERED".equals(shipment.getStatus())) {
            throw new RuntimeException("Cannot cancel shipment that has already been shipped or delivered");
        }

        shipment.setStatus("CANCELLED");
        shipment.setUpdatedAt(LocalDateTime.now());

        return shipmentRepository.save(shipment);
    }
}