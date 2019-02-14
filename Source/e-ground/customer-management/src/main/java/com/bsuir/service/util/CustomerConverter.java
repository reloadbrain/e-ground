package com.bsuir.service.util;

import com.bsuir.dto.CustomerDto;
import com.bsuir.entity.Customer;

import java.util.List;

public interface CustomerConverter {
    CustomerDto toCustomerDto(Customer customer);

    List<CustomerDto> toCustomersDto(List<Customer> customers);

    Customer toCustomer(CustomerDto customerDto);

    List<Customer> toCustomers(List<CustomerDto> customersDto);
}
