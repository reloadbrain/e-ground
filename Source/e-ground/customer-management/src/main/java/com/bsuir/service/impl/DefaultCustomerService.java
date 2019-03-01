package com.bsuir.service.impl;

import com.bsuir.dto.CustomerDto;
import com.bsuir.entity.Customer;
import com.bsuir.exception.EntityNotFoundException;
import com.bsuir.repository.CustomerRepository;
import com.bsuir.service.CustomerService;
import com.bsuir.service.util.CustomerConverter;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Class of customer service that allows you to work with a customer and implements CustomerService.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
@Service
@Transactional
public class DefaultCustomerService implements CustomerService {
    /**
     * Field of customer repository.
     */
    private final CustomerRepository customerRepository;

    private final CustomerConverter converter;

    /**
     * Constructor that accepts a object CustomerDao class.
     *
     * @param customerRepository object of CustomerRepository class
     */
    @Autowired
    public DefaultCustomerService(CustomerRepository customerRepository, CustomerConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    /**
     * Method that save Customer in database.
     *
     * @param customerDto object that needs to save
     * @return saved object of Customer class
     */
    @Override
    public CustomerDto create(CustomerDto customerDto) {
        return converter.toCustomerDto(customerRepository.save(converter.toCustomer(customerDto)));
    }

    /**
     * Method that finds an object in database.
     *
     * @param id UUID of the object to be found
     * @return founded object or NullPointerException
     */
    @Override
    public CustomerDto findById(UUID id) {
        return converter.toCustomerDto(customerRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    /**
     * Method that finds all objects in database.
     *
     * @return founded objects
     */
    @Override
    public List<CustomerDto> findAll() {
        Iterable<Customer> saveCustomers = customerRepository.findAll();
        List<Customer> createdCustomers = new ArrayList<>();
        for (Customer customer : saveCustomers) {
            createdCustomers.add(customer);
        }
        return converter.toCustomersDto(createdCustomers);
    }

    @Override
    public CustomerDto findByEmail(String email) {
        Customer createdCustomer = customerRepository.findByEmail(email);
        return converter.toCustomerDto(createdCustomer);
    }

    @Override
    public CustomerDto findByPhoneNumber(String phoneNumber) {
        Customer createdCustomer = customerRepository.findByPhoneNumber(phoneNumber);
        return converter.toCustomerDto(createdCustomer);
    }

    /**
     * Method that save updated object.
     *
     * @param customerDto updated customer that needs to save
     * @return updated and saved customer
     */
    @Override
    public CustomerDto update(CustomerDto customerDto) {
        return create(customerDto);
    }

    /**
     * Method that delete object.
     *
     * @param id object that needs to delete
     */
    @Override
    public void delete(UUID id) {
        try {
            customerRepository.delete(converter.toCustomer(findById(id)));
        } catch (Exception e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }
}
