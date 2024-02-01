package com.dreamfist.product_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value="product")
@AllArgsConstructor //Generates constructor will all field
@NoArgsConstructor //with no field
@Builder //To use builder pattern to create instance of our class
@Data //Automatically generate getters, setters, equals(), hashCode(), and toString() methods for each field in a class
public class Product {
    @Id //Defined id is unique
    private String id;
    private String name;
    private String desc;
    private BigDecimal price;

}
