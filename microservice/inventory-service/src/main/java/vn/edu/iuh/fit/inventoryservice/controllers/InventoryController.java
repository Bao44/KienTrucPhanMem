package vn.edu.iuh.fit.inventoryservice.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.inventoryservice.models.InventoryItem;
import vn.edu.iuh.fit.inventoryservice.services.InventoryService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{productId}")
    public ResponseEntity<InventoryItem> getInventoryItem(@PathVariable String productId) {
        InventoryItem item = inventoryService.getInventoryItem(productId);
        return ResponseEntity.ok(item);
    }

    @GetMapping("/{productId}/available")
    public ResponseEntity<Boolean> checkAvailability(
            @PathVariable String productId,
            @RequestParam int quantity) {
        boolean isAvailable = inventoryService.isInStock(productId, quantity);
        return ResponseEntity.ok(isAvailable);
    }

    @PostMapping("/{productId}/reserve")
    public ResponseEntity<InventoryItem> reserveStock(
            @PathVariable String productId,
            @RequestBody Map<String, Integer> request) {
        int quantity = request.get("quantity");
        InventoryItem item = inventoryService.reserveStock(productId, quantity);
        return ResponseEntity.ok(item);
    }

    @PostMapping("/{productId}/confirm")
    public ResponseEntity<InventoryItem> confirmReservation(
            @PathVariable String productId,
            @RequestBody Map<String, Integer> request) {
        int quantity = request.get("quantity");
        InventoryItem item = inventoryService.confirmStockReservation(productId, quantity);
        return ResponseEntity.ok(item);
    }

    @PostMapping("/{productId}/cancel")
    public ResponseEntity<InventoryItem> cancelReservation(
            @PathVariable String productId,
            @RequestBody Map<String, Integer> request) {
        int quantity = request.get("quantity");
        InventoryItem item = inventoryService.cancelStockReservation(productId, quantity);
        return ResponseEntity.ok(item);
    }

    @PostMapping("/{productId}/restock")
    public ResponseEntity<InventoryItem> restockInventory(
            @PathVariable String productId,
            @RequestBody Map<String, Integer> request) {
        int quantity = request.get("quantity");
        InventoryItem item = inventoryService.restockInventory(productId, quantity);
        return ResponseEntity.ok(item);
    }

    @GetMapping
    public ResponseEntity<List<InventoryItem>> getAllInventory() {
        List<InventoryItem> inventory = inventoryService.getAllInventory();
        return ResponseEntity.ok(inventory);
    }
}