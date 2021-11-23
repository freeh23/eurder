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

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phonenumber='" + phonenumber + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public static final class Builder {
        private String firstname;
        private String lastname;
        private String email;
        private Address address;
        private String phonenumber;
        private boolean isAdmin;

        private Builder() {
        }

        public static Builder aCustomer() {
            return new Builder();
        }


        public Builder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder withPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
            return this;
        }

        public Builder withIsAdmin(boolean isAdmin) {
            this.isAdmin = isAdmin;
            return this;
        }

        public Customer build() {
            Customer customer = new Customer();
            customer.address = this.address;
            customer.phonenumber = this.phonenumber;
            customer.firstname = this.firstname;
            customer.isAdmin = this.isAdmin;
            customer.email = this.email;
            customer.lastname = this.lastname;
            return customer;
        }
    }
}
