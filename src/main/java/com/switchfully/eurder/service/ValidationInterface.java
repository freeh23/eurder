package com.switchfully.eurder.service;

public interface ValidationInterface {
    void assertCustomerHasAdminRights(String customerId);

    void assertCustomerIdExistsInTheDatabase(String customerId);

    void assertValueIsNotNegative(double value);

    void assertValueIsNotNegative(int value);
}
