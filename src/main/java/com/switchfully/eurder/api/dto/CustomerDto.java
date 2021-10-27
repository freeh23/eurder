package com.switchfully.eurder.api.dto;

import com.switchfully.eurder.domain.Address;

import java.util.UUID;

public class CustomerDto {
    private String customerId;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
    private String phonenumber;

    public CustomerDto setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public CustomerDto setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public CustomerDto setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public CustomerDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerDto setAddress(Address address) {
        this.address = address;
        return this;
    }

    public CustomerDto setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        return this;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
}
