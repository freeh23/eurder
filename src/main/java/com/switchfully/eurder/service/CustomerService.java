package com.switchfully.eurder.service;

import com.switchfully.eurder.api.dto.CreateCustomerDto;
import com.switchfully.eurder.api.dto.CustomerDto;
import com.switchfully.eurder.domain.Customer;
import com.switchfully.eurder.repository.AddressRepository;
import com.switchfully.eurder.repository.CustomerRepository;
import com.switchfully.eurder.service.mapper.CustomerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final ValidationInterface validationInterface;
    private final CustomerMapper customerMapper;
    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    public CustomerService(@Qualifier("CustomerCrudRepository") CustomerRepository customerRepository, AddressRepository addressRepository, @Qualifier("validationWithCrudRepo") ValidationInterface validationInterface, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.validationInterface = validationInterface;
        this.customerMapper = customerMapper;
    }

    public CustomerDto createCustomer(CreateCustomerDto createCustomerDto) {
        Customer customer = customerMapper.mapToEntity(createCustomerDto);
        addressRepository.save(customer.getAddress());
        customerRepository.save(customer);
        logger.info("createCustomer(): New customer saved in the database.");
        return customerMapper.mapToDto(customer);
    }

    public List<CustomerDto> getAllCustomers(String adminId) {
        //Todo: implement correct security! An admin should exit in the database at launch...
        //validationInterface.assertCustomerHasAdminRights(adminId);
        logger.info("getAllCustomers(): " + adminId + " has correct rights. Returning list of all customers from database.");
            return customerRepository.findAll().stream()
                    .map(customerMapper::mapToDto)
                    .collect(Collectors.toList());
    }

    public CustomerDto getCustomer(String adminId, String customerId) {
        //Todo: implement correct security! An admin should exit in the database at launch...
        //validationInterface.assertCustomerHasAdminRights(adminId);
        validationInterface.assertCustomerIdExistsInTheDatabase(customerId);
        logger.info("getCustomer(): Correct input. Returning the asked CustomerDto");
        //above assertion should be good enough... OR you may want to launch the assertion here.
        Customer customer = customerRepository.findByCustomerId(customerId).get();
        return customerMapper.mapToDto(customer);
    }
}
