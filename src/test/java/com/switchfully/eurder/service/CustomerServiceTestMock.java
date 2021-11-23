package com.switchfully.eurder.service;


import com.switchfully.eurder.repository.CustomerRepositoryCrud;
import com.switchfully.eurder.service.mapper.CustomerMapper;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class CustomerServiceTestMock {

    private CustomerService customerService;
    private CustomerRepositoryCrud customerRepositoryMock;
    private ValidationWithCrudRepo validationWithCrudRepo;
    private CustomerMapper customerMapper;

    @BeforeEach
    void setUp() {
        customerRepositoryMock = Mockito.mock(CustomerRepositoryCrud.class);
        customerMapper = new CustomerMapper();
        validationWithCrudRepo = new ValidationWithCrudRepo();
        customerService = new CustomerService(customerRepositoryMock, validationWithCrudRepo, customerMapper);
    }
}
