package com.dreamfist.inventory_service.repository;

import com.dreamfist.inventory_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface InventoryRepo extends JpaRepository<Inventory,Long> {
    //findBySkuCodeIn : remember findBy then attribute in camelcase
    //then if u want search in all records on one column and return list of
    // those which match with given list of arguments to be matched with , then add ‘In’ at the end of method
    List<Inventory> findBySkuCodeIn(List<String> skuCodes); //Spring will implement this at runtime as we have inventory as our saved object type in table

}
