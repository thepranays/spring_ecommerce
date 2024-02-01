package com.dreamfist.product_service.repository;

import com.dreamfist.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product,String> {
    //MongoRepository<Product,String> : Product is type of data we
    //are having in as document in mongodb , string is type of identifier for product


}
