package com.bsuir.service.client;

import com.bsuir.dto.customer.CustomerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class CustomerManagementClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryClient.class);

    private static final String API_V1_CUSTOMER_MANAGEMENT = "api/v1/customer-management/customers";

    private static final String API_V1_CUSTOMER_MANAGEMENT_EMAIL = "api/v1/customer-management/customers/emails/";

    private final RestTemplate restTemplate;

    @Value("${customer-management.url}")
    private String baseUrl;

    @Autowired
    public CustomerManagementClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CustomerDto save(CustomerDto customerDto) {
        LOGGER.info("Start method save CustomerManagementClient.CustomerDto: {}", customerDto);

        StringBuilder finalUrl = new StringBuilder(baseUrl);
        finalUrl.append(API_V1_CUSTOMER_MANAGEMENT);

        LOGGER.info("Final URL: {}", finalUrl.toString());

        ResponseEntity<CustomerDto> responseEntity = restTemplate.postForEntity(finalUrl.toString(), customerDto, CustomerDto.class);

        LOGGER.info("Customer DTO: {}", responseEntity.getBody());
        return responseEntity.getBody();
    }

    public CustomerDto getCustomersDto(String email) {
        LOGGER.info("Start method InventoryClient.getCustomersDto Email = {}", email);


        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("", headers);

        StringBuilder finalUrl = new StringBuilder(baseUrl);
        finalUrl.append(API_V1_CUSTOMER_MANAGEMENT_EMAIL);
        finalUrl.append(email);

        LOGGER.info("Final URL: {}", finalUrl.toString());

        ResponseEntity<CustomerDto> responseEntity = restTemplate.exchange(finalUrl.toString(), HttpMethod.GET, entity, CustomerDto.class);

        LOGGER.info("Customer DTO: {}", responseEntity.getBody());

        return responseEntity.getBody();
    }
}
