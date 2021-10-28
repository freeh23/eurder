package com.switchfully.eurder.repository;

import com.switchfully.eurder.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class CustomerRepository {

    private final HashMap<String, Customer> customerRepo = new HashMap<>();
    Logger logger = LoggerFactory.getLogger(CustomerRepository.class);

    @Autowired
    public CustomerRepository() {
        Customer admin = new Customer()
                .setFirstname("Mr.")
                .setLastname("Admin")
                .setEmail("admin@eurder.com")
                .setAdmin(true);
        addCustomer(admin);
        System.out.println("default admin id: " + admin.getCustomerId());
    }

    public Customer addCustomer(Customer customer) {
        return customerRepo.put(customer.getCustomerId(), customer);
    }



    public int size() {
        return customerRepo.size();
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerRepo.values());
    }

    public boolean contains(String customerId) {
        return customerRepo.containsKey(customerId);
    }


    public Customer getCustomer(String customerId) {
        return customerRepo.get(customerId);
    }
}
