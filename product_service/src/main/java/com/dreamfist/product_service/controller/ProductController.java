package com.dreamfist.product_service.controller;

import com.dreamfist.product_service.dto.ProductReq;
import com.dreamfist.product_service.dto.ProductRes;

import com.dreamfist.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor //It will initialize the required fields (for e.g. product repo here) by creating a constructor
public class ProductController {

    //Spring auto-injecting(constructor injection) product service into controller class through spring bean factory
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductReq productReq){
        productService.createProduct(productReq);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductRes> getAllProducts(){
        return productService.getAllProducts();
    }
}
