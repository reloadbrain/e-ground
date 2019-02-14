package com.bsuir;

import com.bsuir.dto.CustomerDto;
import com.bsuir.entity.Customer;
import com.bsuir.service.CustomerService;
import com.bsuir.service.util.CustomerConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DefaultCustomerDaoTest {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerConverter customerConverter;

    private Customer testCustomer;

    @BeforeEach
    void setUp() {
        testCustomer = new Customer();
        testCustomer.setName("Max");
        testCustomer.setSurname("Brown");
        testCustomer.setAge(19);
    }

    @Test
    void testFindByIdCustomer() {
        testCustomer.setEmail("max_1@gmail.com");
        testCustomer.setPhoneNumber("+79261234517");
        CustomerDto testCustomerDto = customerService.create(customerConverter.toCustomerDto(testCustomer));

        CustomerDto foundCustomerDto = customerService.findById(testCustomerDto.getId());

        assertNotNull(foundCustomerDto);
        assertEquals(testCustomerDto.getName(), foundCustomerDto.getName());
    }

    @Test
    void testUpdateCustomer() {
        testCustomer.setEmail("max_2@gmail.com");
        testCustomer.setPhoneNumber("+79261234527");
        CustomerDto testCustomerDto = customerService.create(customerConverter.toCustomerDto(testCustomer));

        testCustomerDto.setName("Rick");
        CustomerDto updatedCustomerDto = customerService.update(testCustomerDto);

        assertNotNull(updatedCustomerDto);
        assertEquals(testCustomerDto.getName(), updatedCustomerDto.getName());
    }

    @Test
    void testDeleteCustomer() {
        testCustomer.setEmail("max_3@gmail.com");
        testCustomer.setPhoneNumber("+79261234537");
        CustomerDto testCustomerDto = customerService.create(customerConverter.toCustomerDto(testCustomer));

        customerService.delete(testCustomerDto.getId());
    }

    @Test
    void testFindAllCustomer() {
        testCustomer.setEmail("max_4@gmail.com");
        testCustomer.setPhoneNumber("+79261234547");
        customerService.create(customerConverter.toCustomerDto(testCustomer));

        List<CustomerDto> customersDto = customerService.findAll();

        assertNotNull(customersDto);
    }

    @Test
    void testFindByEmailCustomer() {
        testCustomer.setEmail("max_5@gmail.com");
        testCustomer.setPhoneNumber("+79261234557");
        customerService.create(customerConverter.toCustomerDto(testCustomer));

        CustomerDto customersDto = customerService.findByEmail("max_5@gmail.com");

        assertNotNull(customersDto);
    }

    @Test
    void testFindByPhoneNumberCustomer() {
        testCustomer.setEmail("max_6@gmail.com");
        testCustomer.setPhoneNumber("+79261234567");
        customerService.create(customerConverter.toCustomerDto(testCustomer));

        CustomerDto customersDto = customerService.findByPhoneNumber("+79261234567");

        assertNotNull(customersDto);
    }
}
