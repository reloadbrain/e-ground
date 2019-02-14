package com.bsuir.controller;

import com.bsuir.dto.CustomerDto;
import com.bsuir.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Class of Customer REST Controller. Contains CRUD methods.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
@RestController
@RequestMapping(value = "api/v1/customer-management/customers")
public class CustomerController {
    /**
     * Field of customer service.
     */
    private final CustomerService customerService;

    /**
     * Constructor that accepts a object CustomerService class.
     *
     * @param customerService object of CustomerService class
     */
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Method that converts DTO to class object and create it.
     *
     * @param customerDto data transfer object
     * @return created object of Customer class
     */
    @PostMapping
    public CustomerDto create(@Validated @RequestBody CustomerDto customerDto) {
        return customerService.create(customerDto);
    }

    /**
     * Method that finds an object.
     *
     * @param id UUID of the object to be found
     * @return founded object or NullPointerException
     */
    @GetMapping(path = "/{id}")
    public CustomerDto find(@PathVariable("id") UUID id) {
        return customerService.findById(id);
    }

    /**
     * Method that finds an object.
     *
     * @param email UUID of the object to be found
     * @return founded object or NullPointerException
     */
    @GetMapping(path = "/emails/{email}")
    public CustomerDto findByEmail(@PathVariable("email") String email) {
        return customerService.findByEmail(email);
    }

    /**
     * Method that finds an object.
     *
     * @param phoneNumber the object to be found
     * @return founded object or NullPointerException
     */
    @GetMapping(path = "/numbers/{number}")
    public CustomerDto findByPhoneNumber(@PathVariable("number") String phoneNumber) {
        return customerService.findByPhoneNumber(phoneNumber);
    }

    /**
     * Method that finds all objects.
     *
     * @return founded objects
     */
    @GetMapping
    public List<CustomerDto> findAll() {
        return customerService.findAll();
    }

    /**
     * Method that save updated object.
     *
     * @param customerDto updated customer that needs to save
     * @return updated and saved customer
     */
    @PutMapping
    public CustomerDto update(@Validated @RequestBody CustomerDto customerDto) {
        return customerService.update(customerDto);
    }

    /**
     * Method that delete object.
     *
     * @param id object that needs to delete
     */
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") UUID id) {
        customerService.delete(id);
    }
}
