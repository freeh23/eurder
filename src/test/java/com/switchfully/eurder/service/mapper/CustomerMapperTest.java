package com.switchfully.eurder.service.mapper;

import com.switchfully.eurder.api.dto.CreateAddressDto;
import com.switchfully.eurder.api.dto.CreateCustomerDto;
import com.switchfully.eurder.api.dto.CustomerDto;
import com.switchfully.eurder.domain.Address;
import com.switchfully.eurder.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CustomerMapperTest {

    private CustomerMapper customerMapper;

    @BeforeEach
    void setUp() {
        customerMapper = new CustomerMapper();
    }

    @Test
    void givenCustomer_whenMapToDto_thenExpectCorrectCustomerDto() {
        //given
        String firstname = "Jhon";
        String lastname ="Doe";
        String email = "john@mail.com";
        String phonenumber = "0499 99 99 99";
        String street = "fakestreet";
        String houseNumber = "1";
        String city = "Brussel";
        String postalCode = "1000";

        Address address = Address.Builder.anAddress()
                .withStreet(street)
                .withHouseNumber(houseNumber)
                .withCity(city)
                .withPostalCode(postalCode)
                .build();

        Customer customer = Customer.Builder.aCustomer()
                .withFirstname(firstname)
                .withLastname(lastname)
                .withEmail(email)
                .withPhonenumber(phonenumber)
                .withAddress(address)
                .build();

        String uuid = customer.getCustomerId();

        //when
        CustomerDto createdDto = customerMapper.mapToDto(customer);

        //then
        assertEquals(uuid, createdDto.getCustomerId());
        assertEquals(firstname, createdDto.getFirstname());
        assertEquals(lastname, createdDto.getLastname());
        assertEquals(email, createdDto.getEmail());
        assertEquals(phonenumber, createdDto.getPhonenumber());
        assertEquals(street, createdDto.getAddress().getStreet());
        assertEquals(houseNumber, createdDto.getAddress().getHouseNumber());
        assertEquals(postalCode, createdDto.getAddress().getPostalCode());
        assertEquals(city, createdDto.getAddress().getCity());
    }

    @Test
    void givenCreateCustomerDto_whenMapToEntity_thenEntityHasCorrectFields() {
        //given
        String firstname = "Jhon";
        String lastname ="Doe";
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
        Customer customer = customerMapper.mapToEntity(createCustomerDto);

        //then
        assertNotNull(customer.getCustomerId());
        assertEquals(firstname, customer.getFirstname());
        assertEquals(lastname, customer.getLastname());
        assertEquals(email, customer.getEmail());
        assertEquals(phonenumber, customer.getPhonenumber());
        assertEquals(street, customer.getAddress().getStreet());
        assertEquals(houseNumber, customer.getAddress().getHouseNumber());
        assertEquals(postalCode, customer.getAddress().getPostalCode());
        assertEquals(city, customer.getAddress().getCity());
    }
}