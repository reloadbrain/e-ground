package com.bsuir.service.impl;

import com.bsuir.dto.OrderDto;
import com.bsuir.entity.Order;
import com.bsuir.exception.EntityNotFoundException;
import com.bsuir.repository.OrderRepository;
import com.bsuir.service.OrderService;
import com.bsuir.service.util.OrderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Class of order service that allows you to work with a category and implements OrderItemService.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
@Service
@Transactional
public class DefaultOrderService implements OrderService {
    /**
     * Field of Order Repository.
     */
    private final OrderRepository orderRepository;

    private final OrderConverter converter;

    /**
     * Constructor that accepts a object OrderRepository class.
     *
     * @param orderRepository object of OrderRepository class
     */
    @Autowired
    public DefaultOrderService(OrderRepository orderRepository,
                               OrderConverter converter) {
        this.orderRepository = orderRepository;
        this.converter = converter;
    }

    /**
     * Method that save Order in database.
     *
     * @param orderDto object that needs to save
     * @return saved object of Order class
     */
    @Override
    public OrderDto create(OrderDto orderDto) {
        return converter.toOrderDto(orderRepository.save(converter.toOrder(orderDto)));
    }

    /**
     * Method that finds all objects in database.
     *
     * @return founded objects
     */
    @Override
    public List<OrderDto> findAll() {
        Iterable<Order> saveOrders = orderRepository.findAll();
        List<Order> createdOrders = new ArrayList<>();
        for (Order order : saveOrders) {
            createdOrders.add(order);
        }
        return converter.toOrdersDto(createdOrders);
    }

    @Override
    public List<OrderDto> findAllByEmail(String email) {
        Iterable<Order> saveOrders = orderRepository.findAllByEmail(email);
        List<Order> createdOrders = new ArrayList<>();
        for (Order order : saveOrders) {
            createdOrders.add(order);
        }
        return converter.toOrdersDto(createdOrders);
    }

    /**
     * Method that finds an object in database.
     *
     * @param id Long of the object to be found
     * @return founded object or NullPointerException
     */
    @Override
    public OrderDto findById(UUID id) {
        return converter.toOrderDto(orderRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    /**
     * Method that save updated object.
     *
     * @param orderDto updated order that needs to save
     * @return updated and saved order
     */
    @Override
    public OrderDto update(OrderDto orderDto) {
        return create(orderDto);
    }

    /**
     * Method that delete object.
     *
     * @param id object that needs to delete
     */
    @Override
    public void delete(UUID id) {
        try {
            orderRepository.deleteById(id);
        } catch (Exception e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }
}
