package com.bsuir.service.util.impl;

import com.bsuir.dto.inventory.OrderDto;
import com.bsuir.service.util.TemporaryStorage;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class HashMapTemporaryStorage implements TemporaryStorage {
    private Map<String, HashMap<String, OrderDto>> storage = new HashMap<>();

    public HashMapTemporaryStorage() {

    }

    @Override
    public void save(OrderDto orderDto) {
        Map<String, OrderDto> data = storage.get(orderDto.getEmail());
        if (data == null) {
            Map<String, OrderDto> newData = new HashMap<>();
            newData.putIfAbsent(orderDto.getOrderNumber(), orderDto);
            storage.putIfAbsent(orderDto.getEmail(), (HashMap<String, OrderDto>) newData);
        } else {
            data.putIfAbsent(orderDto.getOrderNumber(), orderDto);
            storage.putIfAbsent(orderDto.getEmail(), (HashMap<String, OrderDto>) data);
        }
    }

    @Override
    public OrderDto get(String email, String orderNumber) {
        return storage.get(email).get(orderNumber);
    }

    @Override
    public List<OrderDto> get(String email) {
        List<OrderDto> ordersDto = new ArrayList<>();
        HashMap<String, OrderDto> map = storage.get(email);
        if (map != null) {
            ordersDto.addAll(map.values());
        }
        return ordersDto;
    }

    @Override
    public List<OrderDto> getAll() {
        Collection<HashMap<String, OrderDto>> values = storage.values();
        List<OrderDto> ordersDto = new ArrayList<>();
        values.forEach(map -> ordersDto.addAll(map.values()));
        return ordersDto;
    }

    @Override
    public void delete(String email) {
        storage.remove(email);
    }

    @Override
    public OrderDto delete(String email, String orderNumber) {
        return storage.get(email).remove(orderNumber);
    }

}
