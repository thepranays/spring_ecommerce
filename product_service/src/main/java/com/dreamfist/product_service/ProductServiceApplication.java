package com.dreamfist.product_service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/*
@EnableEurekaClient is deprecated, no need to annotate the main class.
It is enough to add the spring-cloud-starter-netflix-eureka-client
dependency to pom.xml and if we have the application
name in yml or properties file it will be registered to Eureka Server.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
		
	}

}
