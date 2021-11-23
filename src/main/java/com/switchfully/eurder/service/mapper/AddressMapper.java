package com.switchfully.eurder.service.mapper;

import com.switchfully.eurder.api.dto.CreateAddressDto;
import com.switchfully.eurder.domain.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {


    public static Address toEntity(CreateAddressDto dto) {
        return Address.Builder.anAddress()
                .withStreet(dto.getStreet())
                .withHouseNumber(dto.getHouseNumber())
                .withPostalCode(dto.getPostalCode())
                .withCity(dto.getCity())
                .build();
    }


}
