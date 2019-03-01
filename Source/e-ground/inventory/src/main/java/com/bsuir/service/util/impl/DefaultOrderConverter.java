package com.bsuir.service.util.impl;

import com.bsuir.dto.OrderDto;
import com.bsuir.entity.Address;
import com.bsuir.entity.Order;
import com.bsuir.service.util.OrderConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultOrderConverter implements OrderConverter {
    private final DateTimeFormatter ISO_LOCAL_DATE_TIME = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public List<OrderDto> toOrdersDto(List<Order> orders) {
        List<OrderDto> ordersDto = new ArrayList<>();
        if (orders != null) {
            orders.forEach(order -> ordersDto.add(toOrderDto(order)));
        }
        return ordersDto;
    }

    @Override
    public Order toOrder(OrderDto orderDto) {
        Order order = new Order();
        if (orderDto != null) {
            Address address = new Address();

            address.setCity(orderDto.getCity());
            address.setStreet(orderDto.getStreet());
            address.setHouseNumber(orderDto.getHouseNumber());
            order.setDeliveryAddress(address);

            order.setCustomerId(orderDto.getCustomerId());
            order.setId(orderDto.getId());
            order.setName(orderDto.getName());
            order.setEmail(orderDto.getEmail());
            order.setTotalPrice(orderDto.getTotalPrice());
            order.setOrderItemCount(orderDto.getOrderItemCount());
            order.setDate(LocalDateTime.parse(orderDto.getDate()));
        }
        return order;
    }


    @Override
    public OrderDto toOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();
        if (order != null) {


            orderDto.setCustomerId(order.getCustomerId());
            orderDto.setId(order.getId());
            orderDto.setName(order.getName());
            orderDto.setDate(order.getDate().format(ISO_LOCAL_DATE_TIME));
            orderDto.setOrderItemCount(order.getOrderItemCount());
            orderDto.setEmail(order.getEmail());
            orderDto.setTotalPrice(order.getTotalPrice());
            orderDto.setCity(order.getDeliveryAddress().getCity());
            orderDto.setStreet(order.getDeliveryAddress().getStreet());
            orderDto.setHouseNumber(order.getDeliveryAddress().getHouseNumber());
        }
        return orderDto;
    }
}
