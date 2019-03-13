package com.bsuir.sdtt.repository;

import com.bsuir.sdtt.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Interface of Customer repository that extends CrudRepository.
 * Contains CRUD methods and methods for updating customer.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
<<<<<<< HEAD
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByPhoneNumber(String phoneNumber);
=======
>>>>>>> 9a6cef07cd1f440343e01b0a27b58250410d40a1
}
