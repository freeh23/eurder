package com.switchfully.eurder.domain;

import java.util.UUID;

public class Item {
    private final String itemId;
    private String name;
    private String Description;
    private Price price;
    private int amount;

    public Item() {
        this.itemId = UUID.randomUUID().toString();
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public Item setDescription(String description) {
        Description = description;
        return this;
    }

    public Item setPrice(Price price) {
        this.price = price;
        return this;
    }

    public Item setPriceValue(double priceValue) {
        this.price = new Price(priceValue);
        return this;
    }

    public Item setAmount(int amount) {
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
