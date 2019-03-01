package com.bsuir.service;

import com.bsuir.dto.catalog.OfferDto;
import com.bsuir.dto.customer.CustomerDto;
import com.bsuir.dto.inventory.OrderDto;
import com.bsuir.dto.processor.CreateOrderParameterDto;
import com.bsuir.dto.processor.OperationParameterDto;

import java.util.List;
import java.util.UUID;

public interface ProcessorService {
    OrderDto createOrder(CreateOrderParameterDto createOrderParameter);

    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto getCustomerByEmail(String email);

    List<OfferDto> getOffersByFilter(String category, String priceFrom, String priceTo);

    List<OrderDto> getOrdersByStatus(String status);

    OfferDto getOrderById(UUID id);

    List<OrderDto> getAllOrders();

    void delete(OperationParameterDto operationParameterDto);
}
