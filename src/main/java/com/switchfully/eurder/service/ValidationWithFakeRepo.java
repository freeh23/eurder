package com.switchfully.eurder.service;

import com.switchfully.eurder.repository.CustomerRepositoryFake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationWithFakeRepo implements ValidationInterface {

    CustomerRepositoryFake customerRepositoryFake;

    @Autowired
    public ValidationWithFakeRepo(CustomerRepositoryFake customerRepositoryFake) {
        this.customerRepositoryFake = customerRepositoryFake;
    }


    @Override
    public void assertCustomerHasAdminRights(String customerId) {
        assertCustomerIdExistsInTheDatabase(customerId);
        //get ok because of above assertion?
        if (!customerRepositoryFake.findByCustomerId(customerId).get().isAdmin()) {
            throw new IllegalArgumentException(customerId + " does not have admin rights to perform this operation.");
        }
    }

    @Override
    public void assertCustomerIdExistsInTheDatabase(String customerId) {
        if (customerRepositoryFake.findByCustomerId(customerId).isEmpty()) {
            throw new IllegalArgumentException(customerId + " does not exist in the database.");
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
