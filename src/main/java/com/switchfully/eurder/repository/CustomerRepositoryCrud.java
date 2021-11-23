package com.switchfully.eurder.repository;


import com.switchfully.eurder.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("CustomerCrudRepository")
public interface CustomerRepositoryCrud extends CrudRepository<Customer, UUID>, CustomerRepository {

    @Override
    Customer save(Customer customer);

    List<Customer> findAll();



}
