package com.switchfully.eurder.service;

import com.switchfully.eurder.api.dto.CreateAddressDto;
import com.switchfully.eurder.api.dto.CreateCustomerDto;
import com.switchfully.eurder.api.dto.CustomerDto;
import com.switchfully.eurder.domain.Customer;
import com.switchfully.eurder.repository.AddressRepository;
import com.switchfully.eurder.repository.CustomerRepositoryFake;
import com.switchfully.eurder.service.mapper.CustomerMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomerServiceTestWithFakeRepo {

    CustomerService customerService;
    CustomerRepositoryFake customerRepositoryFake;
    ValidationWithFakeRepo validationWithFakeRepo;
    CustomerMapper customerMapper;
    AddressRepository addressRepository;

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
        customerService = new CustomerService(customerRepositoryFake, addressRepository, validationWithFakeRepo, customerMapper);
        customer1 = Customer.Builder.aCustomer().withFirstname("customer1").build();
        customer2 = Customer.Builder.aCustomer().withFirstname("customer2").build();
        customer3 = Customer.Builder.aCustomer().withFirstname("customer3").build();
        customer4 = Customer.Builder.aCustomer().withFirstname("customer4").build();
        admin = Customer.Builder.aCustomer().withIsAdmin(true).withFirstname("admin").build();
        //BEWARE: default admin present by default when calling repo constructor...


        customerRepositoryFake.save(customer1);
        customerRepositoryFake.save(customer2);
        customerRepositoryFake.save(customer3);
        customerRepositoryFake.save(customer4);
        customerRepositoryFake.save(admin);
    }

    //createCustomer tests

    //Todo: make it work! It's probably possible with profiles...
    //history: I was bumping in a problem because the wrong repo is called in the service, because I gave priority
    // to the

    @Test
    void whenCreateCustomer_ThenExpectOneAdditionalEntryInRepo() {
        //given
        int initialAmountOfCustomersInRepo = customerRepositoryFake.size();

        CreateCustomerDto createCustomerDto = CreateCustomerDto.Builder.aCreateCustomerDto()
                .withFirstname("John")
                .withLastname("Doe")
                .withEmail("john@mail.com")
                .withPhonenumber("0499 99 99 99")
                .withAddress(CreateAddressDto.Builder.aCreateAddressDto()
                        .withStreet("fakestreet")
                        .withHouseNumber("1")
                        .withCity("Brussel")
                        .withPostalCode("1000")
                        .build())
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
    void givenARepoWith5Customers_WhenGetAllCustomersIsCalledWithNonAuthorizedId_ThenThrowIllegalArgumentException() {
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> customerService.getAllCustomers(customer2.getCustomerId()));
    }

    /* similar test -> void givenARepoWith5Customers_WhenGetAllCustomers_ThenReturnListOf5Customers()
     */
    @Test
    void givenARepoWith5Customers_WhenGetAllCustomersIsCalledWithAuthorizedId_ThenReturnListOfAllCustomers() {
        //given
        //when
        List<CustomerDto> listOfCustomersInRepo = customerService.getAllCustomers(admin.getCustomerId());
        List<CustomerDto> listOfExpectedCustomers = new ArrayList<>();
        listOfExpectedCustomers.add(customerMapper.mapToDto(customer1));
        listOfExpectedCustomers.add(customerMapper.mapToDto(customer2));
        listOfExpectedCustomers.add(customerMapper.mapToDto(customer3));
        listOfExpectedCustomers.add(customerMapper.mapToDto(customer4));
        listOfExpectedCustomers.add(customerMapper.mapToDto(admin));
        listOfExpectedCustomers.add(customerService.getCustomer(customerRepositoryFake.getDefaultAdminId(), customerRepositoryFake.getDefaultAdminId()));

        //then
        org.assertj.core.api.Assertions.assertThat(listOfExpectedCustomers).hasSameElementsAs(listOfCustomersInRepo);
    }


    //getCustomer tests

    @Test
    void givenARepoWith5Customers_WhenGetCustomerIsCalledWithNonAuthorizedId_ThenThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> customerService.getCustomer(customer2.getCustomerId(), customer3.getCustomerId()));
    }


    @Test
    void givenARepoWith5Customers_WhenGetCustomerWithWrongCustomerId_ThenThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> customerService.getCustomer(admin.getCustomerId(), "randomId"));
    }

    @Test
    void givenARepoWith5Customers_WhenGetCustomerIsCalledWithValidInput_ThenReturnTheRightCustomer() {
        //given

        //when
        CustomerDto calledCustomer = customerService.getCustomer(admin.getCustomerId(), customer3.getCustomerId());

        //then
        assertEquals(customerMapper.mapToDto(customer3), calledCustomer);

    }


}