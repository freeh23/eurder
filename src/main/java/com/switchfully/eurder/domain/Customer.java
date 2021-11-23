package com.switchfully.eurder.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private final String customerId;
    @Column(name = "firstname")
    private String firstname;
    @Column(name ="lastname")
    private String lastname;
    @Column(name ="email")
    private String email;
    @OneToOne
    @JoinColumn(name ="fk_address_id")
    private Address address;
    @Column(name ="phonenumber")
    private String phonenumber;
    @Column(name ="admin")
    private boolean isAdmin;

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

    public Customer setAdmin(boolean admin) {
        isAdmin = admin;
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

    public boolean isAdmin() {
        return isAdmin;
    }
}
