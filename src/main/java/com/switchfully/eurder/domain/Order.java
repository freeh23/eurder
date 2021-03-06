package com.switchfully.eurder.domain;

import java.util.List;
import java.util.UUID;

public class Order {
    private String customerId;
    private final String orderId;
    private List<ItemGroup> listOfItemGroups;

    public Order() {
        this.orderId = UUID.randomUUID().toString();
    }

    public Order setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public Order setListOfItemGroups(List<ItemGroup> listOfItemGroups) {
        this.listOfItemGroups = listOfItemGroups;
        return this;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<ItemGroup> getListOfItemGroups() {
        return listOfItemGroups;
    }
}
