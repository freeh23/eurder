package com.switchfully.eurder.api.dto;

import com.switchfully.eurder.domain.Price;

public class CreateItemDto {

    private String name;
    private String Description;
    private Price price;
    private int amount;

    public CreateItemDto() {
        this.price = new Price(0.0);
    }

    public CreateItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public CreateItemDto setDescription(String description) {
        Description = description;
        return this;
    }

    public CreateItemDto setPrice(Price price) {
        this.price = price;
        return this;
    }

    public CreateItemDto setAmount(int amount) {
        this.amount = amount;
        return this;
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
