package com.switchfully.eurder.api.controller;

import com.switchfully.eurder.api.dto.CreateCustomerDto;
import com.switchfully.eurder.api.dto.CustomerDto;
import com.switchfully.eurder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createCustomer(@RequestBody CreateCustomerDto createCustomerDto) {
        return customerService.createCustomer(createCustomerDto);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getAllCustomer(@RequestParam(name = "authorizedId") String authorizedId) {
        return customerService.getAllCustomers(authorizedId);
    }

    @GetMapping(path ="/{customerId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getCustomer(@PathVariable String customerId, @RequestParam(name = "authorizedId") String authorizedId) {
        return customerService.getCustomer(authorizedId, customerId);
    }
}
