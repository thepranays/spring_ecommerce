package com.dreamfist.inventory_service.repository;

import com.dreamfist.inventory_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface InventoryRepo extends JpaRepository<Inventory,Long> {
    List<Inventory> findBySkuCodes(List<String> skuCode); //Spring will implement this at runtime as we have inventory as our saved object type in table
}
