package com.switchfully.eurder.service;

import com.switchfully.eurder.domain.Customer;
import com.switchfully.eurder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidationWithCrudRepo implements ValidationInterface {

    private final CustomerRepository customerRepository;

    public ValidationWithCrudRepo(@Qualifier("CustomerCrudRepository") CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void assertCustomerIdExistsInTheDatabase(String customerId) {
        Optional<Customer> foundCustomer = customerRepository.findByCustomerId(customerId);
        if (foundCustomer.isEmpty()) {
            throw new IllegalArgumentException(customerId + " does not exist in the database.");
            //WrongIdException:
        }
    }

    @Override
    public void assertCustomerHasAdminRights(String customerId) {
        Optional<Customer> foundCustomer = customerRepository.findByCustomerId(customerId);
            if (foundCustomer.isEmpty() ||!foundCustomer.get().isAdmin()) {
                throw new IllegalArgumentException(customerId + " does not have admin rights to perform this operation.");
                //WrongIdException:
            }
    }



    @Override
    public void assertValueIsNotNegative(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value (" + value + ") can't be negative!");
        }
    }

    @Override
    public void assertValueIsNotNegative(int value) {
        assertValueIsNotNegative((double) value);
    }
}
