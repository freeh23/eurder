package com.switchfully.eurder.api.dto;

public class CreateItemGroupDto {
    private String itemId;
    private int amountOrdered;

    public CreateItemGroupDto setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public CreateItemGroupDto setAmountOrdered(int amountOrdered) {
        this.amountOrdered = amountOrdered;
        return this;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }
}
