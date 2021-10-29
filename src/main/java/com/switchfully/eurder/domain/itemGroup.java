package com.switchfully.eurder.domain;

import java.time.LocalDate;

public class itemGroup {
    private String itemId;
    private int amount;
    private LocalDate shippingDate;

    public itemGroup setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public itemGroup setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public itemGroup setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
