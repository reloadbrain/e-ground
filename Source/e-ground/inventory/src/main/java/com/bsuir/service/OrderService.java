package com.bsuir.service;

import com.bsuir.dto.OrderDto;

import java.util.List;
import java.util.UUID;

/**
 * Interface of order service. Contains CRUD methods.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
public interface OrderService {
    OrderDto create(OrderDto orderDto);

    List<OrderDto> findAll();

    OrderDto findById(UUID id);

    OrderDto update(OrderDto orderDto);

    void delete(UUID id);
}
