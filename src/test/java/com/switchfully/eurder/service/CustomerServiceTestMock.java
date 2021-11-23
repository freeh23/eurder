package com.switchfully.eurder.service;


import com.switchfully.eurder.api.dto.CreateAddressDto;
import com.switchfully.eurder.api.dto.CreateCustomerDto;
import com.switchfully.eurder.api.dto.CustomerDto;
import com.switchfully.eurder.domain.Customer;
import com.switchfully.eurder.repository.AddressRepository;
import com.switchfully.eurder.repository.CustomerRepositoryCrud;
import com.switchfully.eurder.service.mapper.CustomerMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CustomerServiceTestMock {

    private CustomerService customerService;
    private CustomerRepositoryCrud customerRepositoryMock;
    private AddressRepository addressRepositoryMock;
    private ValidationWithCrudRepo validationWithCrudRepo;
    private CustomerMapper customerMapper;
    private CustomerMapper customerMapperMock;

    @BeforeEach
    void setUp() {
        customerRepositoryMock = Mockito.mock(CustomerRepositoryCrud.class);
        addressRepositoryMock = Mockito.mock(AddressRepository.class);
        customerMapper = new CustomerMapper();
        customerMapperMock = Mockito.mock(CustomerMapper.class);
        validationWithCrudRepo = new ValidationWithCrudRepo(customerRepositoryMock);
        customerService = new CustomerService(customerRepositoryMock, addressRepositoryMock, validationWithCrudRepo, customerMapper);
    }

    @Test
    void whenCreateCustomer_thenExpectRepoSaveMethodIsCalled() {
        //given
        String firstname = "Jhon";
        String lastname = "Doe";
        String email = "john@mail.com";
        String phonenumber = "0499 99 99 99";
        String street = "fakestreet";
        String houseNumber = "1";
        String city = "Brussel";
        String postalCode = "1000";

        CreateCustomerDto createCustomerDto = CreateCustomerDto.Builder.aCreateCustomerDto()
                .withFirstname(firstname)
                .withLastname(lastname)
                .withEmail(email)
                .withPhonenumber(phonenumber)
                .withAddress(CreateAddressDto.Builder.aCreateAddressDto()
                        .withStreet(street)
                        .withHouseNumber(houseNumber)
                        .withCity(city)
                        .withPostalCode(postalCode)
                        .build())
                .build();
/*
        Customer stubbedCustomer = customerMapper.mapToEntity(createCustomerDto); //new UUID here
        Customer testCustomer = Customer.Builder.aCustomer()
                .withFirstname(firstname)
                .withLastname(lastname)
                .withEmail(email)
                .withPhonenumber(phonenumber)
                .withAddress(Address.Builder.anAddress()
                        .withStreet(street)
                        .withHouseNumber(houseNumber)
                        .withPostalCode(postalCode)
                        .withCity(city)
                        .build()
                ).withPhonenumber(phonenumber)
                .withIsAdmin(false)
                .build();
        Mockito.when(customerMapperMock.mapToEntity(createCustomerDto)).thenReturn(testCustomer);



        Mockito.when(customerRepositoryMock.save(testCustomer)).thenReturn(testCustomer);


*/

        //when
        customerService.createCustomer(createCustomerDto);

        //then
        Mockito.verify(customerRepositoryMock).save(ArgumentMatchers.any(Customer.class));
    }

    @Test
    void whenCreateCustomer_thenExpectCorrectReturn() {
        //given
        String firstname = "Jhon";
        String lastname = "Doe";
        String email = "john@mail.com";
        String phonenumber = "0499 99 99 99";
        String street = "fakestreet";
        String houseNumber = "1";
        String city = "Brussel";
        String postalCode = "1000";

        CreateCustomerDto createCustomerDto = CreateCustomerDto.Builder.aCreateCustomerDto()
                .withFirstname(firstname)
                .withLastname(lastname)
                .withEmail(email)
                .withPhonenumber(phonenumber)
                .withAddress(CreateAddressDto.Builder.aCreateAddressDto()
                        .withStreet(street)
                        .withHouseNumber(houseNumber)
                        .withCity(city)
                        .withPostalCode(postalCode)
                        .build())
                .build();


        //when
        CustomerDto result = customerService.createCustomer(createCustomerDto);

        //then
        assertEquals(firstname, result.getFirstname());
        assertEquals(lastname, result.getLastname());
        assertEquals(email, result.getEmail());
        assertEquals(phonenumber, result.getPhonenumber());
        assertEquals(street, result.getAddress().getStreet());
        assertEquals(houseNumber, result.getAddress().getHouseNumber());
        assertEquals(postalCode, result.getAddress().getPostalCode());
        assertEquals(city, result.getAddress().getCity());

    }

    @Test
    void givenDataInRepository_whenGetAllCustomersWithoutAdminRights_thenThrowException() {
        fail();
    }

    @Test
    void givenDataInRepository_whenGetAllCustomersWithAdminRights_thenReturnAListOfCustomerDto() {
        fail();
    }

    @Test
    void givenDataInRepository_whenGetCustomerByIdWithoutAdminRights_thenThrowException() {
        fail();
    }

    @Test
    void givenDataInRepository_whenGetCustomerByIdWithAdminRights_thenReturnACustomerDto() {
        fail();
    }

    @Test
    void givenDataInRepository_whenGetCustomerByIdWithAdminRightsButWithWrongCustomerId_thenThrowException() {
        fail();
    }

}
