package com.switchfully.eurder.service;

import com.switchfully.eurder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Validation {

    CustomerRepository customerRepository;

    @Autowired
    public Validation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public void assertCustomerHasAdminRights(String customerId) {
        assertCustomerIdExistsInTheDatabase(customerId);
        if (!customerRepository.getCustomer(customerId).isAdmin()) {
            throw new IllegalArgumentException(customerId + " does not have admin rights to perform this operation.");
        }
    }

    public void assertCustomerIdExistsInTheDatabase(String customerId) {
        if (!customerRepository.contains(customerId)) {
            throw new IllegalArgumentException(customerId + " does not exist in the database.");
        }
    }

    public void assertValueIsNotNegative(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value (" + value + ") can't be negative!");
        }
    }

    public void assertValueIsNotNegative(int value) {
        assertValueIsNotNegative((double) value);
    }
}
