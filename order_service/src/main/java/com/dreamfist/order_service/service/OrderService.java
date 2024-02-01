package com.dreamfist.order_service.service;

import com.dreamfist.order_service.dto.InventoryRes;
import com.dreamfist.order_service.dto.OrderLineItemDto;
import com.dreamfist.order_service.dto.OrderReq;
import com.dreamfist.order_service.model.Order;
import com.dreamfist.order_service.model.OrderLineItem;
import com.dreamfist.order_service.repository.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class OrderService {


    //Constructor injection
    private final OrderRepo orderRepo;
    private final WebClient webClient; //Auto-injected by referencing bean name


    public void createOrder(OrderReq orderReq){
        Order order=new Order();
        order.setOrderNo(UUID.randomUUID().toString());
        List<OrderLineItem> orderLineItemList=orderReq.getOrderLineItemDtoList()
                .stream()
                .map(this::mapOrderLineItems).toList();
        order.setOrderLineItemList(orderLineItemList);

        //Store order list to a List<String> having sku_codes to be passed as query parameter
        List<String> orderList = order.getOrderLineItemList().stream().map(OrderLineItem::getSkuCode).toList();

        //Check whether the ordered items are available in inventory
        // HTTP-GET REQUEST To inventory service , uses skyCode as query parameter
        InventoryRes[] inventoryResultArray = webClient.get().uri("http://localhost:8082/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("sku_code",orderList).build())
                .retrieve()
                .bodyToMono(InventoryRes[].class)
                .block(); //await for response

        boolean hasAllOrderInStock = Arrays.stream(inventoryResultArray).allMatch(InventoryRes::isInStock);
        if(hasAllOrderInStock){
            orderRepo.save(order);
            return;
        }
        throw new IllegalArgumentException("Product not in inventory stock");

    }

    private OrderLineItem mapOrderLineItems(OrderLineItemDto item) {
        OrderLineItem orderLineItem=new OrderLineItem();
        orderLineItem.setPrice(item.getPrice());
        orderLineItem.setQuantity(item.getQuantity());
        orderLineItem.setSkuCode(item.getSkuCode());
        return orderLineItem;
    }
}
