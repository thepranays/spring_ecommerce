package com.dreamfist.notification_service;

import com.dreamfist.notification_service.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Arrays;

@SpringBootApplication
@Slf4j //Slf4j used for logging
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}


	@KafkaListener(topics = "orderNotifyTopic")
	public void consumeOrderNotification(OrderCreatedEvent orderCreatedEvent){
		//TODO:Send push notification
		log.info("Received notification for order - {}",orderCreatedEvent.getOrderNumber());
		log.info("Items- {}", Arrays.toString(orderCreatedEvent.getOrderLineItemList().toArray()));
	}

}
