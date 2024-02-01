package com.dreamfist.product_service.service;

import com.dreamfist.product_service.dto.ProductReq;
import com.dreamfist.product_service.dto.ProductRes;
import com.dreamfist.product_service.model.Product;
import com.dreamfist.product_service.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //It will initialize the required fields (for e.g. product repo here) by creating a constructor
@Slf4j //To add logs
public class ProductService {

    //Spring auto-injecting(constructor injection) ProductRepository into service class through spring bean factory
    private final ProductRepo productRepo;

    public void createProduct(ProductReq productReq){
        Product product=Product.builder()
                .name(productReq.getName())
                .desc(productReq.getDesc())
                .price(productReq.getPrice())
                .build();

        productRepo.save(product);
        log.info("Product {} is created",product.getId());
    }

    public List<ProductRes> getAllProducts(){
        List<Product> productList = productRepo.findAll(); //mongodb model has method find all to get all documents of type product
        return productList.stream().map(this::convToProductRes).toList(); // (product)->convToProduceRes(product)
    }

    private ProductRes convToProductRes(Product p) {
        return ProductRes.builder().name(p.getName()).desc(p.getDesc()).price(p.getPrice()).id(p.getId()).build();
    }
}
