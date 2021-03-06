package com.switchfully.eurder.api.dto;

import com.switchfully.eurder.domain.Address;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerId='" + customerId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
