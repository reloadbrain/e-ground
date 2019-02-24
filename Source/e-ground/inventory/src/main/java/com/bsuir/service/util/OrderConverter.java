package com.bsuir.service.util;

import com.bsuir.dto.OrderDto;
import com.bsuir.entity.Order;

import java.util.List;

public interface OrderConverter {
    Order toOrder(OrderDto orderDto);

    OrderDto toOrderDto(Order order);

    List<OrderDto> toOrdersDto(List<Order> orders);
}
