package com.switchfully.eurder.api.dto;


public class CreateItemDto {

    private String name;
    private String Description;
    private double priceValue;
    private int amount;


    public CreateItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public CreateItemDto setDescription(String description) {
        Description = description;
        return this;
    }

    public CreateItemDto setPriceValue(double priceValue) {
        this.priceValue = priceValue;
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

    public double getPriceValue() {
        return priceValue;
    }

    public int getAmount() {
        return amount;
    }

}
