package vn.edu.iuh.fit.inventoryservice.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.inventoryservice.models.InventoryItem;
import vn.edu.iuh.fit.inventoryservice.repositories.InventoryRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public InventoryItem getInventoryItem(String productId) {
        return inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Inventory item not found for product: " + productId));
    }

    public boolean isInStock(String productId, int quantity) {
        Optional<InventoryItem> inventoryItemOpt = inventoryRepository.findByProductId(productId);
        if (!inventoryItemOpt.isPresent()) {
            return false;
        }

        InventoryItem item = inventoryItemOpt.get();
        return item.getQuantity() - item.getReservedQuantity() >= quantity;
    }

    @Transactional
    public InventoryItem reserveStock(String productId, int quantity) {
        InventoryItem item = getInventoryItem(productId);

        if (item.getQuantity() - item.getReservedQuantity() < quantity) {
            throw new RuntimeException("Not enough stock available for product: " + productId);
        }

        item.setReservedQuantity(item.getReservedQuantity() + quantity);
        item.setUpdatedAt(LocalDateTime.now());

        return inventoryRepository.save(item);
    }

    @Transactional
    public InventoryItem confirmStockReservation(String productId, int quantity) {
        InventoryItem item = getInventoryItem(productId);

        if (item.getReservedQuantity() < quantity) {
            throw new RuntimeException("Reserved quantity issue for product: " + productId);
        }

        item.setQuantity(item.getQuantity() - quantity);
        item.setReservedQuantity(item.getReservedQuantity() - quantity);
        item.setUpdatedAt(LocalDateTime.now());

        return inventoryRepository.save(item);
    }

    @Transactional
    public InventoryItem cancelStockReservation(String productId, int quantity) {
        InventoryItem item = getInventoryItem(productId);

        if (item.getReservedQuantity() < quantity) {
            throw new RuntimeException("Reserved quantity issue for product: " + productId);
        }

        item.setReservedQuantity(item.getReservedQuantity() - quantity);
        item.setUpdatedAt(LocalDateTime.now());

        return inventoryRepository.save(item);
    }

    @Transactional
    public InventoryItem restockInventory(String productId, int quantity) {
        Optional<InventoryItem> itemOpt = inventoryRepository.findByProductId(productId);
        InventoryItem item;

        if (itemOpt.isPresent()) {
            item = itemOpt.get();
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            item = new InventoryItem();
            item.setProductId(productId);
            item.setQuantity(quantity);
            item.setLocation("MAIN_WAREHOUSE");
            item.setReservedQuantity(0);
        }

        item.setUpdatedAt(LocalDateTime.now());
        return inventoryRepository.save(item);
    }

    public List<InventoryItem> getAllInventory() {
        return inventoryRepository.findAll();
    }
}