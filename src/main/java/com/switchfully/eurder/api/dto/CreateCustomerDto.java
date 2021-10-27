package com.switchfully.eurder.api.dto;

import com.switchfully.eurder.domain.Address;

public class CreateCustomerDto {

    private String firstname;
    private String lastname;
    private String email;
    private Address address;
    private String phonenumber;

    public CreateCustomerDto setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public CreateCustomerDto setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public CreateCustomerDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public CreateCustomerDto setAddress(Address address) {
        this.address = address;
        return this;
    }

    public CreateCustomerDto setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        return this;
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
