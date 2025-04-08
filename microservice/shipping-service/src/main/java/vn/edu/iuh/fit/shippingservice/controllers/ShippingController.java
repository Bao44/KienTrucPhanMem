package vn.edu.iuh.fit.shippingservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.shippingservice.models.Shipment;
import vn.edu.iuh.fit.shippingservice.services.ShippingService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping
    public ResponseEntity<Shipment> createShipment(@RequestBody Map<String, String> request) {
        String orderId = request.get("orderId");
        String address = request.get("address");
        Shipment shipment = shippingService.createShipment(orderId, address);
        return ResponseEntity.ok(shipment);
    }

    @PutMapping("/{shipmentId}/status")
    public ResponseEntity<Shipment> updateShipmentStatus(
            @PathVariable Long shipmentId,
            @RequestBody Map<String, String> request) {
        String status = request.get("status");
        Shipment shipment = shippingService.updateShipmentStatus(shipmentId, status);
        return ResponseEntity.ok(shipment);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<Shipment>> getShipmentsByOrderId(@PathVariable String orderId) {
        List<Shipment> shipments = shippingService.getShipmentsByOrderId(orderId);
        return ResponseEntity.ok(shipments);
    }

    @GetMapping("/tracking/{trackingNumber}")
    public ResponseEntity<Shipment> getShipmentByTrackingNumber(@PathVariable String trackingNumber) {
        Shipment shipment = shippingService.getShipmentByTrackingNumber(trackingNumber);
        return ResponseEntity.ok(shipment);
    }

    @PostMapping("/{shipmentId}/cancel")
    public ResponseEntity<Shipment> cancelShipment(@PathVariable Long shipmentId) {
        Shipment shipment = shippingService.cancelShipment(shipmentId);
        return ResponseEntity.ok(shipment);
    }
}
