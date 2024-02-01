package com.dreamfist.order_service.controller;

import com.dreamfist.order_service.dto.OrderReq;
import com.dreamfist.order_service.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {

    //Constructor injection
    private final OrderService orderService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody OrderReq orderReq){
        orderService.createOrder(orderReq);
        return "Order successfully placed.";
    }
}
