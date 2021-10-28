package com.switchfully.eurder.domain;


public class Price {
    private double priceValue;
    private final Currency currency;

    public Price(double priceValue) {
        this.priceValue = priceValue;
        this.currency = Currency.EUR;
    }

    public double getPriceValue() {
        return priceValue;
    }

    public Price setPriceValue(double priceValue) {
        this.priceValue = priceValue;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }


    enum Currency {
        EUR
    }

}
