package com.dreamfist.product_service;

import com.dreamfist.product_service.dto.ProductReq;
import com.dreamfist.product_service.repository.ProductRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*Junit 5 Tests*/

@Testcontainers //To tell JUnit-5 we are using test containers to run these tests
@SpringBootTest
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Container //provided by test container, starts the docker image with given image tag
	static MongoDBContainer mongoDBContainer =new MongoDBContainer("mongo:4.4.2");

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper; //to convert pojo object to json and vice versa

	@Autowired
	private ProductRepo productRepo;

	@DynamicPropertySource //this will dynamically set the property during test run time
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.data.mongodb.uri",mongoDBContainer::getReplicaSetUrl);
	}

	@Test //Create Product : POST : Integration Test
	void shouldCreateProduct() throws Exception {
		ProductReq productReq=getProductReq();
		String productRequest = objectMapper.writeValueAsString(productReq);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(productRequest))
				.andExpect(status().isCreated());
		Assertions.assertEquals(1,productRepo.findAll().size());
	}

	public ProductReq getProductReq(){
		return ProductReq.builder().name("Test").desc("test").price(BigDecimal.valueOf(1000)).build();
	}

	@Test //Get all Products : GET : Integration Test
	void shouldGetAllProducts() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/product"))
				.andExpect(status().isOk());

	}

}
