package com.switchfully.eurder.repository;

import com.switchfully.eurder.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class CustomerRepository {

    private final HashMap<String, Customer> customerRepo = new HashMap<>();

    public Customer addCustomer(Customer customer) {
        return customerRepo.put(customer.getCustomerId(), customer);
    }



    public int size() {
        return customerRepo.size();
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerRepo.values());
    }
}
