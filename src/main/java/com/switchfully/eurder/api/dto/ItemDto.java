package com.switchfully.eurder.api.dto;

import com.switchfully.eurder.domain.Price;

public class ItemDto {

    private String itemId;
    private String name;
    private String Description;
    private Price price;
    private int amount;

    public ItemDto setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public ItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public ItemDto setDescription(String description) {
        Description = description;
        return this;
    }

    public ItemDto setPrice(Price price) {
        this.price = price;
        return this;
    }

    public ItemDto setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return Description;
    }

    public Price getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

}
