package com.bsuir.service;

import com.bsuir.dto.CustomerDto;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    CustomerDto create(CustomerDto customerDto);

    CustomerDto findById(UUID id);

    CustomerDto findByEmail(String email);

    CustomerDto findByPhoneNumber(String phoneNumber);

    List<CustomerDto> findAll();

    CustomerDto update(CustomerDto customerDto);

    void delete(UUID id);
}
