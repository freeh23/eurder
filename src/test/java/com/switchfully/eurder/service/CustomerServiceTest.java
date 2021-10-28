package com.switchfully.eurder.service;

import com.switchfully.eurder.api.dto.CreateCustomerDto;
import com.switchfully.eurder.api.dto.CustomerDto;
import com.switchfully.eurder.domain.Address;
import com.switchfully.eurder.domain.Customer;
import com.switchfully.eurder.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CustomerServiceTest {

    CustomerService service;
    CustomerRepository repository;

    Customer customer1;
    Customer customer2;
    Customer customer3;
    Customer customer4;

    Customer admin;

    @BeforeEach
    void setup() {
        repository = new CustomerRepository();
        service = new CustomerService(repository);
        customer1 = new Customer();
        customer2 = new Customer();
        customer3 = new Customer();
        customer4 = new Customer();
        admin = new Customer().setAdmin(true);
    }

    //createCustomer tests

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


    //getAllCustomers tests

    @Test
    void givenARepoWith4Customers_WhenGetAllCustomers_ThenReturnListOf4Customers() {
        //given
        repository.addCustomer(customer1);
        repository.addCustomer(customer2);
        repository.addCustomer(customer3);
        repository.addCustomer(customer4);

        //when
        List<CustomerDto> listOfCustomers = service.getAllCustomers(admin.getCustomerId());

        //then
        Assertions.assertEquals(4, listOfCustomers.size());
    }

    @Test
    void givenARepoWith4Customers_WhenGetAllCustomersIsCalledWithNonAuthorizedId_ThenThrowIllegalArgumentException () {

        Assertions.fail();
    }

    @Test
    void givenARepoWith4Customers_WhenGetAllCustomersIsCalledWithAuthorizedId_ThenReturnListOfAllCustomers () {
        Assertions.fail();
    }


    //getCustomer tests

    @Test
    void givenARepoWith4Customers_WhenGetCustomerIsCalledWithNonAuthorizedId_ThenThrowIllegalArgumentException () {
        Assertions.fail();
    }


    @Test
    void givenARepoWith4Customers_WhenGetCustomerWithWrongCustomerId_ThenThrowIllegalArgumentException () {
        Assertions.fail();
    }

    @Test
    void givenARepoWith4Customers_WhenGetCustomerIsCalledWithValidInput_ThenReturnTheRightCustomer () {
        Assertions.fail();
    }



}