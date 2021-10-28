package com.switchfully.eurder.service;

import com.switchfully.eurder.api.dto.CreateCustomerDto;
import com.switchfully.eurder.api.dto.CustomerDto;
import com.switchfully.eurder.domain.Customer;
import com.switchfully.eurder.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    public CustomerDto createCustomer(CreateCustomerDto createCustomerDto) {
        Customer customer = mapCreateCustomerDtoToCustomer(createCustomerDto);
        customerRepository.addCustomer(customer);
        logger.info("New customer saved in the database.");
        return mapCustomerToCustomerDto(customer);
    }

    public List<CustomerDto> getAllCustomers(String adminId) {
        assertUserHasAdminRights(adminId);
        logger.info(adminId + " has correct rights. Returning list of all customers from database.");
            return customerRepository.getAllCustomers().stream()
                    .map(this::mapCustomerToCustomerDto)
                    .collect(Collectors.toList());
    }

    public CustomerDto getCustomer(String adminId, String customerId) {
        assertUserHasAdminRights(adminId);
        assertIdExistsInTheDatabase(customerId);
        logger.info("Correct input. Returning the asked CustomerDto");
        return mapCustomerToCustomerDto(customerRepository.getCustomer(customerId));
    }

    private void assertUserHasAdminRights(String adminId) {
        assertIdExistsInTheDatabase(adminId);
        if (!customerRepository.getCustomer(adminId).isAdmin()) {
            throw new IllegalArgumentException(adminId + " does not have admin rights to perform this operation.");
        }
    }

    private void assertIdExistsInTheDatabase(String customerId) {
        if (!customerRepository.contains(customerId)) {
            throw new IllegalArgumentException(customerId + " does not exist in the database.");
        }
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
