package com.dreamfist.inventory_service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
/*
@EnableEurekaClient is deprecated, no need to annotate the main class.
It is enough to add the spring-cloud-starter-netflix-eureka-client
dependency to pom.xml and if we have the application
name in yml or properties file it will be registered to Eureka Server.
 */

@EnableDiscoveryClient
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
