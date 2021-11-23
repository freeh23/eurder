package com.switchfully.eurder.service.mapper;

import com.switchfully.eurder.api.dto.CreateCustomerDto;
import com.switchfully.eurder.api.dto.CustomerDto;
import com.switchfully.eurder.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    @Autowired
    public CustomerMapper() {
    }

    public CustomerDto mapToDto(Customer customer) {
        return new CustomerDto()
                .setCustomerId(customer.getCustomerId())
                .setFirstname(customer.getFirstname())
                .setLastname(customer.getLastname())
                .setEmail(customer.getEmail())
                .setAddress(customer.getAddress())
                .setPhonenumber(customer.getPhonenumber());
    }

    public Customer mapToEntity(CreateCustomerDto createCustomerDto) {
        return Customer.Builder.aCustomer()
                .withFirstname(createCustomerDto.getFirstname())
                .withLastname(createCustomerDto.getLastname())
                .withEmail(createCustomerDto.getEmail())
                .withAddress(AddressMapper.toEntity(createCustomerDto.getCreateAddressDto()))
                .withPhonenumber(createCustomerDto.getPhonenumber())
                .build();
    }
}
