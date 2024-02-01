package com.dreamfist.order_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    //Creates a bean with name webClient when application starts and injects
    // it at placed where needed as dependency ,just use same name 'webClient'
    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }
}
