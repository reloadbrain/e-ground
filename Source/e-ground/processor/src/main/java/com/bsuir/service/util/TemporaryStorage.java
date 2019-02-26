package com.bsuir.service.util;

import com.bsuir.dto.inventory.OrderDto;

import java.util.List;

public interface TemporaryStorage {
    void save(OrderDto data);

    OrderDto get(String email, String orderNumber);

    List<OrderDto> get(String email);

    List<OrderDto> getAll();

    OrderDto delete(String email, String orderNumber);

    void delete(String email);
}
