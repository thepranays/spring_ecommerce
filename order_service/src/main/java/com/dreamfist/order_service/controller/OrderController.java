package com.dreamfist.order_service.controller;

import com.dreamfist.order_service.dto.OrderReq;
import com.dreamfist.order_service.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {

    //Constructor injection
    private final OrderService orderService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name="inventory",fallbackMethod = "createOrderFallBackMethod") //Resilience4j will apply circuit breaker pattern to whatever http request made in below method
    @TimeLimiter(name = "inventory") //Throws time out exception if hits time limit
    @Retry(name="inventory")
    public CompletableFuture<String> createOrder(@RequestBody OrderReq orderReq){ //As time limiter will make asynchronous call thus we have the return type CompletableFuture

        return CompletableFuture.supplyAsync(()->orderService.createOrder(orderReq));//Executes the lambda function in different thread and returns the computed value returned from that function as future's value
    }

    public CompletableFuture<String> createOrderFallBackMethod(OrderReq orderReq,RuntimeException runtimeException){
        return CompletableFuture.supplyAsync(()-> "Sorry! , 503: Down/Congested"); //Executes the lambda function in different thread and returns the computed value returned from that function as future's value
    }

}
