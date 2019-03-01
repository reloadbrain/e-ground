package com.bsuir.controller;

import com.bsuir.dto.catalog.OfferDto;
import com.bsuir.dto.customer.CustomerDto;
import com.bsuir.dto.inventory.OrderDto;
import com.bsuir.dto.processor.CreateOrderParameterDto;
import com.bsuir.dto.processor.OperationParameterDto;
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
    public OrderDto addToFavorites(@Validated @RequestBody CreateOrderParameterDto createOrderParameter) {
        return processorService.createOrder(createOrderParameter);
    }

    @PostMapping(path = "/customers")
    public CustomerDto createCustomer(@Validated @RequestBody CustomerDto customerDto) {
        return processorService.createCustomer(customerDto);
    }

    @GetMapping(path = "/customers/emails/{email}")
    public CustomerDto getCustomersById(@PathVariable("email") String email) {
        return processorService.getCustomerByEmail(email);
    }

    @GetMapping(path = "/orders/filter")
    public List<OfferDto> getOffersByFilter(@RequestParam(value = "category", required = false) String category,
                                            @RequestParam(value = "priceFrom", required = false) String priceFrom,
                                            @RequestParam(value = "priceTo", required = false) String priceTo) {
        return processorService.getOffersByFilter(category, priceFrom, priceTo);
    }

    @GetMapping(path = "/orders/statuses/{status}")
    public List<OrderDto> getOrdersByStatus(@PathVariable("status") String status) {
        return processorService.getOrdersByStatus(status);
    }

    @GetMapping(path = "/orders/{id}")
    public OfferDto getOrderById(@PathVariable("id") UUID id) {
        return processorService.getOrderById(id);
    }

    @DeleteMapping(path = "/orders")
    public void delete(@Validated @RequestBody OperationParameterDto operationParameterDto) {
        processorService.delete(operationParameterDto);
    }

}
