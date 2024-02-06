package com.dreamfist.notification_service.event;

import com.dreamfist.notification_service.model.OrderLineItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreatedEvent {
    private String orderNumber;
    private List<OrderLineItem> orderLineItemList;
}
