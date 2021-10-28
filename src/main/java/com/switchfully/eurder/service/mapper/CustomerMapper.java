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

    public CustomerDto mapCustomerToCustomerDto(Customer customer) {
        return new CustomerDto()
                .setCustomerId(customer.getCustomerId())
                .setFirstname(customer.getFirstname())
                .setLastname(customer.getLastname())
                .setEmail(customer.getEmail())
                .setAddress(customer.getAddress())
                .setPhonenumber(customer.getPhonenumber());
    }

    public Customer mapCreateCustomerDtoToCustomer(CreateCustomerDto createCustomerDto) {
        return new Customer()
                .setFirstname(createCustomerDto.getFirstname())
                .setLastname(createCustomerDto.getLastname())
                .setEmail(createCustomerDto.getEmail())
                .setAddress(createCustomerDto.getAddress())
                .setPhonenumber(createCustomerDto.getPhonenumber());
    }
}
