package com.dreamfist.inventory_service;

import com.dreamfist.inventory_service.model.Inventory;
import com.dreamfist.inventory_service.repository.InventoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableD
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

//	@Bean // this will be loaded at time of start of application
//	public CommandLineRunner loadDummyData(InventoryRepo inventoryRepo){ //method injection
//		return args -> {
//			Inventory inv1=new Inventory();
//			inv1.setQuantity(1000);
//			inv1.setSkuCode("rtx2070");
//			Inventory inv2=new Inventory();
//			inv2.setQuantity(0);
//			inv2.setSkuCode("rtx4070");
//			inventoryRepo.save(inv1);
//			inventoryRepo.save(inv2);
//		};
//	}

}
