package com.dreamfist.inventory_service.service;


import com.dreamfist.inventory_service.dto.InventoryRes;
import com.dreamfist.inventory_service.model.Inventory;
import com.dreamfist.inventory_service.repository.InventoryRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepo inventoryRepo; //construction injection by spring

    @Transactional(readOnly = true)
    public List<InventoryRes> isInStock(List<String> skuCode){

        return inventoryRepo.findBySkuCodes(skuCode).stream()
                .map(inventory ->
                     InventoryRes.builder()
                            .inStock(inventory.getQuantity()>0)
                            .skuCode(inventory.getSkuCode())
                            .build()
                ).toList();
    }
}
