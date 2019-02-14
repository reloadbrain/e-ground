package com.bsuir.service.util.impl;

import com.bsuir.dto.CustomerDto;
import com.bsuir.entity.Customer;
import com.bsuir.service.util.CustomerConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultCustomerConverter implements CustomerConverter {
    @Override
    public CustomerDto toCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        if (customer != null) {
            customerDto.setId(customer.getId());
            customerDto.setName(customer.getName());
            customerDto.setSurname(customer.getSurname());
            customerDto.setAge(customer.getAge());
            customerDto.setEmail(customer.getEmail());
            customerDto.setPhoneNumber(customer.getPhoneNumber());
        }
        return customerDto;
    }

    @Override
    public List<CustomerDto> toCustomersDto(List<Customer> customers) {
        List<CustomerDto> customersDto = new ArrayList<>();
        customers.forEach(customer -> customersDto.add(toCustomerDto(customer)));
        return customersDto;
    }

    @Override
    public Customer toCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        if (customerDto != null) {
            customer.setId(customerDto.getId());
            customer.setName(customerDto.getName());
            customer.setSurname(customerDto.getSurname());
            customer.setAge((byte) customerDto.getAge());
            customer.setEmail(customerDto.getEmail());
            customer.setPhoneNumber(customerDto.getPhoneNumber());
        }
        return customer;
    }

    @Override
    public List<Customer> toCustomers(List<CustomerDto> customersDto) {
        List<Customer> customers = new ArrayList<>();
        customersDto.forEach(customerDto -> customers.add(toCustomer(customerDto)));
        return customers;
    }
}
