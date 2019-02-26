package com.bsuir.service.impl;

import com.bsuir.dto.catalog.OfferDto;
import com.bsuir.dto.customer.CustomerDto;
import com.bsuir.dto.inventory.OrderDto;
import com.bsuir.dto.processor.CreateOrderParameterDto;
import com.bsuir.dto.processor.OperationParameterDto;
import com.bsuir.service.ProcessorService;
import com.bsuir.service.client.CatalogClient;
import com.bsuir.service.client.CustomerManagementClient;
import com.bsuir.service.client.InventoryClient;
import com.bsuir.service.util.TemporaryStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DefaultProcessorService implements ProcessorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultProcessorService.class);

    private static final String IN_PROGRESS = "IN_PROGRESS";

    private static final String DONE = "DONE";

    private final CatalogClient catalogClient;

    private final InventoryClient inventoryClient;

    private final CustomerManagementClient customerManagementClient;

    private final TemporaryStorage storage;

    @Autowired
    public DefaultProcessorService(CatalogClient catalogClient, InventoryClient inventoryClient,
                                   CustomerManagementClient customerManagementClient, TemporaryStorage storage) {
        this.catalogClient = catalogClient;
        this.inventoryClient = inventoryClient;
        this.customerManagementClient = customerManagementClient;
        this.storage = storage;
    }

    @Override
    public OrderDto createOrder(CreateOrderParameterDto createOrderParameter) {
        OrderDto orderDto = new OrderDto();

        String email = createOrderParameter.getEmail();

        LOGGER.info("Start method DefaultProcessorService.createOrder Email = {}", email);

        if (createOrderParameter.getEmail().equals(customerManagementClient.getCustomersDto(email).getEmail())) {
            orderDto.setOrderNumber(createOrderNumber(email));
            orderDto.setStatus(IN_PROGRESS);
            orderDto.setName(createOrderParameter.getName());
            orderDto.setEmail(email);
            orderDto.setTotalPrice(createOrderParameter.getPrice() * createOrderParameter.getOrderItemCount());
            orderDto.setOrderItemCount(createOrderParameter.getOrderItemCount());
            orderDto.setDate(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

            orderDto.setCity(createOrderParameter.getCity());
            orderDto.setStreet(createOrderParameter.getStreet());
            orderDto.setHouseNumber(createOrderParameter.getHouseNumber());

            orderDto.setCategory(createOrderParameter.getCategory());

            storage.save(orderDto);
        }

        return orderDto;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        LOGGER.debug("Start method DefaultProcessorService.createCustomer Customer DTO = {}, Address DTO = {]", customerDto);

        return customerManagementClient.save(customerDto);
    }

    @Override
    public List<OfferDto> getOffersByFilter(String category, String priceFrom, String priceTo) {
        LOGGER.info("Start method DefaultProcessorService.getOffersByFilter");

        return catalogClient.getOffersDto(category, priceFrom, priceTo);
    }


    @Override
    public List<OrderDto> getOrdersByEmail(String email) {
        LOGGER.info("Start method DefaultProcessorService.getOrdersByEmail Email = {}", email);

        List<OrderDto> orders = storage.get(email);
        orders.addAll(inventoryClient.getOrdersDto(email));
        return orders;
    }

    @Override
    public CustomerDto getCustomerByEmail(String email) {
        LOGGER.info("Start method DefaultProcessorService.getCustomersByEmail Email = {}", email);

        return customerManagementClient.getCustomersDto(email);
    }

    @Override
    public String getOrdersTotalPriceByEmail(String email) {
        LOGGER.info("Start method DefaultProcessorService.getOrdersTotalPriceByEmail Email = {}", email);

        double totalPrice = 0;
        List<OrderDto> orders = inventoryClient.getOrdersDto(email);
        for (OrderDto orderDto : orders) {
            totalPrice += orderDto.getTotalPrice();
        }
        return String.valueOf(totalPrice);
    }

    @Override
    public List<OrderDto> getOrdersByStatus(String status) {
        LOGGER.info("Start method DefaultProcessorService.getOrdersByStatus Status = {}", status);

        List<OrderDto> orders = new ArrayList<>();
        String statusUpperCase = status.toUpperCase();
        if (statusUpperCase.equals(DONE)) {
            orders.addAll(inventoryClient.getOrdersDto());
        } else if (statusUpperCase.equals(IN_PROGRESS)) {
            orders.addAll(getAllOrders());
        }
        return orders;
    }

    @Override
    public OrderDto getOrder(String orderNumber) {
        LOGGER.info("Start method DefaultProcessorService.getOrder Order Number = {}", orderNumber);

        List<OrderDto> orders = storage.getAll();
        orders.addAll(inventoryClient.getOrdersDto());
        OrderDto foundOrder = null;
        for (OrderDto orderDto : orders) {
            if (orderDto.getOrderNumber().equals(orderNumber)) {
                foundOrder = orderDto;
            }
        }
        return foundOrder;
    }

    @Override
    public OfferDto getOrderById(UUID id) {
        LOGGER.info("Start method DefaultProcessorService.getOrderById ID = {}", id);

        return catalogClient.getOfferDto(id);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        LOGGER.info("Start method DefaultProcessorService.getAllOrders");
        return storage.getAll();
    }

    @Override
    public OrderDto payOrder(String email, String orderNumber) {
        LOGGER.info("Start method DefaultProcessorService.payOrder Email = {} Order Number = {}", email, orderNumber);

        OrderDto orderDto = storage.get(email, orderNumber);
        if (orderDto != null) {
            orderDto.setStatus(DONE);
            OrderDto savedOrderDto = inventoryClient.save(orderDto);
            storage.delete(savedOrderDto.getEmail(), orderDto.getOrderNumber());
            orderDto = savedOrderDto;
        }
        return orderDto;
    }

    @Override
    public void delete(OperationParameterDto operationParameterDto) {
        LOGGER.info("Start method DefaultProcessorService.deleteItem Operation Parameter DTO = {}", operationParameterDto);

        storage.delete(operationParameterDto.getEmail(), operationParameterDto.getOrderNumber());
    }

    private String createOrderNumber(String email) {
        LOGGER.info("Start method DefaultProcessorService.createOrderNumber Email = {}", email);

        LocalDateTime now = LocalDateTime.now();
        long orderNumber = now.hashCode() + email.hashCode();
        return String.valueOf(Math.abs(orderNumber));
    }
}
