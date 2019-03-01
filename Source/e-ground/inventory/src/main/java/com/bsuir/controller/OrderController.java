package com.bsuir.controller;

import com.bsuir.dto.OrderDto;
import com.bsuir.service.OrderService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Class of Order REST Controller. Contains CRUD methods.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
@RestController
@RequestMapping(value = "api/v1/inventory/orders")
public class OrderController {
    /**
     * Field of Order Service.
     */
    private final OrderService orderService;

    /**
     * Constructor that accepts a object OrderService class.
     *
     * @param orderService object of OrderService class
     */
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Method that converts DTO to class object and create it.
     *
     * @param orderDto data transfer object
     * @return created object of Order class
     */
    @PostMapping
    public OrderDto create(@ApiParam(name = "date", value = "Example date: 2018-12-12T15:15:15")@Validated @RequestBody OrderDto orderDto) {
        return orderService.create(orderDto);
    }

    /**
     * Method that finds an object.
     *
     * @param id UUID of the object to be found
     * @return founded object or NullPointerException
     */
    @GetMapping(path = "/{id}")
    public OrderDto getById(@PathVariable("id") UUID id) {
        return orderService.findById(id);
    }

    /**
     * Method that finds all objects.
     *
     * @return founded objects
     */
    @GetMapping
    public List<OrderDto> getAll() {
        return orderService.findAll();
    }

    /**
     * Method that save updated object.
     *
     * @param orderDto updated order that needs to save
     * @return updated and saved order
     */
    @PutMapping
    public OrderDto update(@Validated @RequestBody OrderDto orderDto) {
        return orderService.update(orderDto);
    }

    /**
     * Method that delete object.
     *
     * @param id object that needs to delete
     */
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") UUID id) {
        orderService.delete(id);
    }
}
