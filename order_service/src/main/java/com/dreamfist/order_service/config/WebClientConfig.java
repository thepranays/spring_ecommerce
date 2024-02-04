package com.dreamfist.order_service.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    //Creates a bean with name webClient when application starts and injects
    // it at placed where needed as dependency ,just use same name 'webClient'
    @Bean
    @LoadBalanced //This will add client side load-balancing capabilities to webclient builder
    public WebClient.Builder webClient(){ //When multiple instances of one service are found then ony after another they will be called until one responds
        return WebClient.builder();
    }
}
