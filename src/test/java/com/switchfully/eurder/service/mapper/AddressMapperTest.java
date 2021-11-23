package com.switchfully.eurder.service.mapper;

import com.switchfully.eurder.api.dto.CreateAddressDto;
import com.switchfully.eurder.domain.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressMapperTest {

    @Test
    void givenCreateAddressDto_whenMapToEntity_thenExpectAddress() {
        //given
        String street = "fakestreet";
        String houseNumber = "1";
        String city = "Brussel";
        String postalCode = "1000";
        CreateAddressDto createAddressDto = CreateAddressDto.Builder.aCreateAddressDto()
                .withStreet(street)
                .withHouseNumber(houseNumber)
                .withCity(city)
                .withPostalCode(postalCode)
                .build();

        //when
        Address address = AddressMapper.toEntity(createAddressDto);

        //then
        assertEquals(street, address.getStreet());
        assertEquals(houseNumber, address.getHouseNumber());
        assertEquals(city, address.getCity());
        assertEquals(postalCode, address.getPostalCode());
    }
}