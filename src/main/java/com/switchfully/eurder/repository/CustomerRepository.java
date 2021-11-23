package com.switchfully.eurder.repository;

import com.switchfully.eurder.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    Customer save(Customer customer);

    List<Customer> findAll();

    Optional<Customer> findByCustomerId(String customerId);
}
