package com.dreamfist.order_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="table_orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //to auto increment primary key for each new record
    private Long id;
    private String orderNo;

    @OneToMany(cascade = CascadeType.ALL) // CascadeType. ALL is used, and any
    // operation performed on the parent entity will be automatically propagated to all child entities.
    private List<OrderLineItem> orderLineItemList;


}
