package com.switchfully.eurder.service;

import com.switchfully.eurder.api.dto.CreateCustomerDto;
import com.switchfully.eurder.api.dto.CustomerDto;
import com.switchfully.eurder.domain.Customer;
import com.switchfully.eurder.repository.CustomerRepository;
import com.switchfully.eurder.service.mapper.CustomerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final Validation validation;
    private final CustomerMapper customerMapper;
    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    public CustomerService(CustomerRepository customerRepository, Validation validation, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.validation = validation;
        this.customerMapper = customerMapper;
    }

    public CustomerDto createCustomer(CreateCustomerDto createCustomerDto) {
        Customer customer = customerMapper.mapCreateCustomerDtoToCustomer(createCustomerDto);
        customerRepository.addCustomer(customer);
        logger.info("createCustomer(): New customer saved in the database.");
        return customerMapper.mapCustomerToCustomerDto(customer);
    }

    public List<CustomerDto> getAllCustomers(String adminId) {
        validation.assertCustomerHasAdminRights(adminId);
        logger.info("getAllCustomers(): " + adminId + " has correct rights. Returning list of all customers from database.");
            return customerRepository.getAllCustomers().stream()
                    .map(customerMapper::mapCustomerToCustomerDto)
                    .collect(Collectors.toList());
    }

    public CustomerDto getCustomer(String adminId, String customerId) {
        validation.assertCustomerHasAdminRights(adminId);
        validation.assertCustomerIdExistsInTheDatabase(customerId);
        logger.info("getCustomer(): Correct input. Returning the asked CustomerDto");
        return customerMapper.mapCustomerToCustomerDto(customerRepository.getCustomer(customerId));
    }
}
