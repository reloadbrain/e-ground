package com.bsuir.service.util.impl;

import com.bsuir.dto.AddressDto;
import com.bsuir.dto.OrderDto;
import com.bsuir.entity.Address;
import com.bsuir.entity.Order;
import com.bsuir.service.util.OrderConverter;
import org.springframework.beans.BeanUtils;
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
            BeanUtils.copyProperties(orderDto.getDeliveryAddress(), address);

            order.setId(orderDto.getId());
            order.setName(orderDto.getName());
            order.setStatus(orderDto.getStatus());
            order.setEmail(orderDto.getEmail());
            order.setTotalPrice(orderDto.getTotalPrice());
            order.setOrderItemCount(orderDto.getOrderItemCount());
            order.setDate(LocalDateTime.parse(orderDto.getDate()));
            order.setDeliveryAddress(address);
            order.setOrderNumber(orderDto.getOrderNumber());
        }
        return order;
    }


    @Override
    public OrderDto toOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();
        if (order != null) {
            AddressDto addressDto = new AddressDto();
            BeanUtils.copyProperties(order.getDeliveryAddress(), addressDto);

            orderDto.setId(order.getId());
            orderDto.setName(order.getName());
            orderDto.setDate(order.getDate().format(ISO_LOCAL_DATE_TIME));
            orderDto.setOrderItemCount(order.getOrderItemCount());
            orderDto.setStatus(order.getStatus());
            orderDto.setEmail(order.getEmail());
            orderDto.setTotalPrice(order.getTotalPrice());
            orderDto.setDeliveryAddress(addressDto);
            orderDto.setOrderNumber(order.getOrderNumber());
        }
        return orderDto;
    }
}
