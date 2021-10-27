package com.switchfully.eurder.domain;

import java.util.UUID;

public class Customer {
    private String customerId;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
    private String phonenumber;

    public Customer() {
        this.customerId = UUID.randomUUID().toString();
    }

    public Customer setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public Customer setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public Customer setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Customer setPhonenumber(String phonenumber) {
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
