package com.switchfully.eurder.service;

import com.switchfully.eurder.api.dto.CreateCustomerDto;
import com.switchfully.eurder.domain.Address;
import com.switchfully.eurder.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerServiceTest {

    CustomerService service;
    CustomerRepository repository;

    @BeforeEach
    void setup() {
        repository = new CustomerRepository();
        service = new CustomerService(repository);
    }

    @Test
    void whenCreateCustomer_ThenExpectOneAdditionalEntryInRepo() {
        //given
        int initialCustomersInRep = repository.size();
        CreateCustomerDto createCustomerDto = new CreateCustomerDto()
                .setFirstname("John")
                .setLastname("Doe")
                .setEmail("john@mail.com")
                .setPhonenumber("0499 99 99 99")
                .setAddress(new Address()
                        .setStreet("fakestreet")
                        .setHouseNumber("1")
                        .setCity("Brussel")
                        .setPostalCode("1000"));

        //when
        service.createCustomer(createCustomerDto);

        //then
        Assertions.assertEquals(initialCustomersInRep + 1, repository.size());
    }

}