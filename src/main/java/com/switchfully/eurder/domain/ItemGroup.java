package com.switchfully.eurder.domain;

import java.time.LocalDate;

public class ItemGroup {
    private String itemId;
    private int amountOrdered;
    private LocalDate shippingDate;

    public ItemGroup setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public ItemGroup setAmountOrdered(int amountOrdered) {
        this.amountOrdered = amountOrdered;
        return this;
    }

    public ItemGroup setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
