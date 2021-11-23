package com.switchfully.eurder.repository;

import com.switchfully.eurder.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryCrudTest {

    @Autowired
    private CustomerRepositoryCrud customerRepositoryCrud;
    private String customerId;

    @BeforeEach
    void setUp() {
        Customer customer = customerRepositoryCrud.save(Customer.Builder.aCustomer().build());
        customerId = customer.getCustomerId();
    }

    @Test
    void givenFindByCustomerId_whenExistingIdAsArgument_thenResultIsNotNull() {
        //given
        //when
        Optional<Customer> customerOptional = customerRepositoryCrud.findByCustomerId(customerId);

        Customer customer = null;
        if (customerOptional.isPresent()) {
            customer = customerOptional.get();
        }
        //then
        assertNotNull(customer);
    }

    @Test
    void givenFindById_whenNonExistingIdAsArgument_thenResultNull() {
        //given
        //when
        Optional<Customer> customerOptional = customerRepositoryCrud.findByCustomerId("something");

        Customer customer = null;
        if (customerOptional.isPresent()) {
            customer = customerOptional.get();
        }

        //then
        assertNull(customer);
    }

    @Test
    void givenRepoWithOneEntry_whenFindAll_thenNumberOfEntriesMustBeEqualToOne() {
        //given
        //when
        int numberOfEntries = customerRepositoryCrud.findAll().size();

        //then
        assertEquals(1, numberOfEntries);
    }

    @Test
    void whenSave_thenNumberOfEntriesPlusOne() {
        //given
        int numberOfEntriesBefore = customerRepositoryCrud.findAll().size();

        //when
        customerRepositoryCrud.save(Customer.Builder.aCustomer().build());

        //then
        assertEquals(numberOfEntriesBefore + 1, customerRepositoryCrud.findAll().size());
    }




}