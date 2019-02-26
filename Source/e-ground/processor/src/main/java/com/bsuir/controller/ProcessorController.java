package com.bsuir.controller;

import com.bsuir.dto.catalog.OfferDto;
import com.bsuir.dto.customer.CustomerDto;
import com.bsuir.dto.inventory.OrderDto;
import com.bsuir.dto.processor.CreateOrderParameterDto;
import com.bsuir.dto.processor.OperationParameterDto;
import com.bsuir.dto.processor.PayParameterDto;
import com.bsuir.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/processor")
public class ProcessorController {
    private final ProcessorService processorService;

    @Autowired
    public ProcessorController(ProcessorService processorService) {
        this.processorService = processorService;
    }

    @PostMapping(path = "/orders")
    public OrderDto createOrder(@Validated @RequestBody CreateOrderParameterDto createOrderParameter) {
        return processorService.createOrder(createOrderParameter);
    }

    @PostMapping(path = "/customers")
    public CustomerDto createCustomer(@Validated @RequestBody CustomerDto customerDto) {
        return processorService.createCustomer(customerDto);
    }

    @GetMapping(path = "/customers/emails/{email}")
    public CustomerDto getCustomersByEmail(@PathVariable("email") String email) {
        return processorService.getCustomerByEmail(email);
    }

    @GetMapping(path = "/orders/emails/{email}")
    public List<OrderDto> getOrdersByEmail(@PathVariable("email") String email) {
        return processorService.getOrdersByEmail(email);
    }

    @GetMapping(path = "/orders/filter")
    public List<OfferDto> getOffersByFilter(@RequestParam(value = "category", required = false) String category,
                                            @RequestParam(value = "priceFrom", required = false) String priceFrom,
                                            @RequestParam(value = "priceTo", required = false) String priceTo) {
        return processorService.getOffersByFilter(category, priceFrom, priceTo);
    }

    @GetMapping(path = "/orders/emails/{email}/prices")
    public String getOrdersTotalPriceByEmail(@PathVariable("email") String email) {
        return processorService.getOrdersTotalPriceByEmail(email);
    }

    @GetMapping(path = "/orders/statuses/{status}")
    public List<OrderDto> getOrdersByStatus(@PathVariable("status") String status) {
        return processorService.getOrdersByStatus(status);
    }

    @GetMapping(path = "/orders/numbers/{number}")
    public OrderDto getOrder(@PathVariable("number") String orderNumber) {
        return processorService.getOrder(orderNumber);
    }

    @GetMapping(path = "/orders/{id}")
    public OfferDto getOrderById(@PathVariable("id") UUID id) {
        return processorService.getOrderById(id);
    }

    @PostMapping(path = "/orders/statuses")
    public OrderDto payOrder(@Validated @RequestBody PayParameterDto payParameter) {
        return processorService.payOrder(payParameter.getEmail(), payParameter.getOrderNumber());
    }

    @DeleteMapping(path = "/orders")
    public void delete(@Validated @RequestBody OperationParameterDto operationParameterDto) {
        processorService.delete(operationParameterDto);
    }

}
