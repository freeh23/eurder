package com.switchfully.eurder.repository;

import com.switchfully.eurder.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryFake implements CustomerRepository {

    private final HashMap<String, Customer> customerRepo = new HashMap<>();
    Logger logger = LoggerFactory.getLogger(CustomerRepositoryFake.class);
    String defaultAdminId;

    @Autowired
    public CustomerRepositoryFake() {
        Customer admin = new Customer()
                .setFirstname("Mr.")
                .setLastname("Admin")
                .setEmail("admin@eurder.com")
                .setAdmin(true);
        save(admin);
        System.out.println("default admin id: " + admin.getCustomerId());
        defaultAdminId = admin.getCustomerId();
    }

    public Customer save(Customer customer) {
        return customerRepo.put(customer.getCustomerId(), customer);
    }



    public int size() {
        return customerRepo.size();
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerRepo.values());
    }

    public Optional<Customer> findByCustomerId(String customerId) {
        Customer customer = customerRepo.get(customerId);
            return Optional.ofNullable(customer);
    }


    public Customer getCustomer(String customerId) {
        return customerRepo.get(customerId);
    }

    public String getDefaultAdminId() {
        return this.defaultAdminId;
    }
}
