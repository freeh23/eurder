package com.switchfully.eurder.api.dto;

import com.switchfully.eurder.domain.ItemGroup;

import java.util.List;

public class OrderDto {
    private String customerId;
    private String orderId;
    private List<ItemGroup> listOfItemGroups;

    public OrderDto setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public OrderDto setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public OrderDto setListOfItemGroups(List<ItemGroup> listOfItemGroups) {
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
