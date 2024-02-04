package com.dreamfist.inventory_service.controller;

import com.dreamfist.inventory_service.dto.InventoryRes;
import com.dreamfist.inventory_service.model.Inventory;
import com.dreamfist.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

   private final InventoryService inventoryService; //constructor injection


   //http://localhost:8082/api/inventory/rtx2060,rtx3060 -> Path variable format
   // @GetMapping("/{sku_code}")      //we can do @PathVariable("sku_code") String skuCode  //If don't want to adhere to naming conventions

   //http://localhost:8082/api/inventory?sku_code=rtx2060&sku_code=rtx3060 -> Request Parameter format
   @GetMapping
   @ResponseStatus(HttpStatus.OK)
   public List<InventoryRes> isInStock(@RequestParam List<String> sku_code){



      return this.inventoryService.isInStock(sku_code);
   }
}
