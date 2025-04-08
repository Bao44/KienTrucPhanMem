package vn.edu.iuh.fit.inventoryservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.inventoryservice.models.InventoryItem;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {
    Optional<InventoryItem> findByProductId(String productId);
}