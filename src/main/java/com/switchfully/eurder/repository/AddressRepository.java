package com.switchfully.eurder.repository;

import com.switchfully.eurder.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
