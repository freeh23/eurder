package com.switchfully.eurder.service;

import com.switchfully.eurder.api.dto.CreateCustomerDto;
import com.switchfully.eurder.api.dto.CustomerDto;
import com.switchfully.eurder.domain.Address;
import com.switchfully.eurder.domain.Customer;
import com.switchfully.eurder.repository.CustomerRepositoryFake;
import com.switchfully.eurder.service.mapper.CustomerMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class CustomerServiceTestWithFakeRepo {

    CustomerService customerService;
    CustomerRepositoryFake customerRepositoryFake;
    ValidationWithFakeRepo validationWithFakeRepo;
    CustomerMapper customerMapper;

    Customer customer1;
    Customer customer2;
    Customer customer3;
    Customer customer4;

    Customer admin;

    @BeforeEach
    void setup() {
        customerRepositoryFake = new CustomerRepositoryFake();
        validationWithFakeRepo = new ValidationWithFakeRepo(customerRepositoryFake);
        customerMapper = new CustomerMapper();
        customerService = new CustomerService(customerRepositoryFake, validationWithFakeRepo, customerMapper);
        customer1 = new Customer().setFirstname("customer1");
        customer2 = new Customer().setFirstname("customer2");
        customer3 = new Customer().setFirstname("customer3");
        customer4 = new Customer().setFirstname("customer4");
        admin = new Customer().setAdmin(true).setFirstname("admin");
        //BEWARE: default admin present by default when calling repo constructor...


        customerRepositoryFake.save(customer1);
        customerRepositoryFake.save(customer2);
        customerRepositoryFake.save(customer3);
        customerRepositoryFake.save(customer4);
        customerRepositoryFake.save(admin);
    }

    //createCustomer tests

    @Test
    void whenCreateCustomer_ThenExpectOneAdditionalEntryInRepo() {
        //given
        int initialAmountOfCustomersInRepo = customerRepositoryFake.size();
        /*
        CreateCustomerDto createCustomerDto = new CreateCustomerDto()
                .setFirstname("John")
                .setLastname("Doe")
                .setEmail("john@mail.com")
                .setPhonenumber("0499 99 99 99")
                .setAddress(new Address()
                        .setStreet("fakestreet")
                        .setHouseNumber("1")
                        .setCity("Brussel")
                        .setPostalCode("1000"));*/
        CreateCustomerDto createCustomerDto = CreateCustomerDto.CreateCustomerDtoBuilder.builder()
                .withFirstname("John")
                .withLastname("Doe")
                .withEmail("john@mail.com")
                .withPhonenumber("0499 99 99 99")
                .withAddress(new Address()
                        .setStreet("fakestreet")
                        .setHouseNumber("1")
                        .setCity("Brussel")
                        .setPostalCode("1000"))
                .build();


        //when
        customerService.createCustomer(createCustomerDto);

        //then
        assertEquals(initialAmountOfCustomersInRepo + 1, customerRepositoryFake.size());
    }


    //getAllCustomers tests

    @Test
    void givenARepoWith5Customers_WhenGetAllCustomers_ThenReturnListOf5Customers() {
        //given

        //when
        List<CustomerDto> listOfCustomers = customerService.getAllCustomers(admin.getCustomerId());

        //then
        assertEquals(6, listOfCustomers.size());
    }

    @Test
    void givenARepoWith5Customers_WhenGetAllCustomersIsCalledWithNonAuthorizedId_ThenThrowIllegalArgumentException () {
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> customerService.getAllCustomers(customer2.getCustomerId()));
    }

    /* similar test -> void givenARepoWith5Customers_WhenGetAllCustomers_ThenReturnListOf5Customers()
    */
    @Test
    void givenARepoWith5Customers_WhenGetAllCustomersIsCalledWithAuthorizedId_ThenReturnListOfAllCustomers () {
        //given
        //when
        List<CustomerDto> listOfCustomersInRepo = customerService.getAllCustomers(admin.getCustomerId());
        List<CustomerDto> listOfExpectedCustomers = new ArrayList<>();
                listOfExpectedCustomers.add(customerMapper.mapCustomerToCustomerDto(customer1));
                listOfExpectedCustomers.add(customerMapper.mapCustomerToCustomerDto(customer2));
                listOfExpectedCustomers.add(customerMapper.mapCustomerToCustomerDto(customer3));
                listOfExpectedCustomers.add(customerMapper.mapCustomerToCustomerDto(customer4));
                listOfExpectedCustomers.add(customerMapper.mapCustomerToCustomerDto(admin));
                listOfExpectedCustomers.add(customerService.getCustomer(customerRepositoryFake.getDefaultAdminId(), customerRepositoryFake.getDefaultAdminId()));

        //then
        org.assertj.core.api.Assertions.assertThat(listOfExpectedCustomers).hasSameElementsAs(listOfCustomersInRepo);
    }


    //getCustomer tests

    @Test
    void givenARepoWith5Customers_WhenGetCustomerIsCalledWithNonAuthorizedId_ThenThrowIllegalArgumentException () {
        assertThrows(IllegalArgumentException.class, () -> customerService.getCustomer(customer2.getCustomerId(), customer3.getCustomerId()));
    }


    @Test
    void givenARepoWith5Customers_WhenGetCustomerWithWrongCustomerId_ThenThrowIllegalArgumentException () {
        assertThrows(IllegalArgumentException.class, () -> customerService.getCustomer(admin.getCustomerId(), "randomId"));
    }

    @Test
    void givenARepoWith5Customers_WhenGetCustomerIsCalledWithValidInput_ThenReturnTheRightCustomer () {
        //given

        //when
        CustomerDto calledCustomer = customerService.getCustomer(admin.getCustomerId(), customer3.getCustomerId());

        //then
        assertEquals(customerMapper.mapCustomerToCustomerDto(customer3), calledCustomer);

    }



}