package com.switchfully.eurder.service;

import com.switchfully.eurder.api.dto.CreateCustomerDto;
import com.switchfully.eurder.api.dto.CustomerDto;
import com.switchfully.eurder.domain.Address;
import com.switchfully.eurder.domain.Customer;
import com.switchfully.eurder.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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


        repository.addCustomer(customer1);
        repository.addCustomer(customer2);
        repository.addCustomer(customer3);
        repository.addCustomer(customer4);
        repository.addCustomer(admin);
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
    void givenARepoWith5Customers_WhenGetAllCustomers_ThenReturnListOf5Customers() {
        //given

        //when
        List<CustomerDto> listOfCustomers = service.getAllCustomers(admin.getCustomerId());

        //then
        Assertions.assertEquals(5, listOfCustomers.size());
    }

    @Test
    void givenARepoWith5Customers_WhenGetAllCustomersIsCalledWithNonAuthorizedId_ThenThrowIllegalArgumentException () {
        //given
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getAllCustomers(customer2.getCustomerId()));
    }

    /* similar test -> void givenARepoWith5Customers_WhenGetAllCustomers_ThenReturnListOf5Customers()
    */
    @Test
    void givenARepoWith5Customers_WhenGetAllCustomersIsCalledWithAuthorizedId_ThenReturnListOfAllCustomers () {
        //given
        //when
        List<CustomerDto> listOfCustomersInRep = service.getAllCustomers(admin.getCustomerId());
        List<CustomerDto> listOfExpectedCustomers = new ArrayList<>();
                listOfExpectedCustomers.add(service.mapCustomerToCustomerDto(customer1));
                listOfExpectedCustomers.add(service.mapCustomerToCustomerDto(customer2));
                listOfExpectedCustomers.add(service.mapCustomerToCustomerDto(customer3));
                listOfExpectedCustomers.add(service.mapCustomerToCustomerDto(customer4));
                listOfExpectedCustomers.add(service.mapCustomerToCustomerDto(admin));

        //then
        org.assertj.core.api.Assertions.assertThat(listOfCustomersInRep).hasSameElementsAs(listOfExpectedCustomers);
    }


    //getCustomer tests

    @Test
    void givenARepoWith5Customers_WhenGetCustomerIsCalledWithNonAuthorizedId_ThenThrowIllegalArgumentException () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getCustomer(customer2.getCustomerId(), customer3.getCustomerId()));
    }


    @Test
    void givenARepoWith5Customers_WhenGetCustomerWithWrongCustomerId_ThenThrowIllegalArgumentException () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.getCustomer(admin.getCustomerId(), "randomId"));
    }

    @Test
    void givenARepoWith5Customers_WhenGetCustomerIsCalledWithValidInput_ThenReturnTheRightCustomer () {
        //given

        //when
        CustomerDto calledCustomer = service.getCustomer(admin.getCustomerId(), customer3.getCustomerId());

        //then
        Assertions.assertEquals(service.mapCustomerToCustomerDto(customer3), calledCustomer);

    }



}