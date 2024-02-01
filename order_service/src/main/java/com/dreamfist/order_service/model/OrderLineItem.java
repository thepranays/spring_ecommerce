package com.dreamfist.order_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "table_order_lineitems")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //to auto increment primary key for each new record
    private Long id;
    private String skuCode; // Unique code to each order
    private BigDecimal price;
    private Integer quantity;


}
