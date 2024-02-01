package com.dreamfist.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderReq {
    private List<OrderLineItemDto> orderLineItemDtoList;
}
