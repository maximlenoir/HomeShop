package com.mlenoir.homeshop;

public class ExpressDelivery implements Delivery {
    private String city;

    public ExpressDelivery(String city) {
        this.city = city;
    }

    @Override
    public String getInfo() {
        return "Livraison à domicile express 24h";
    }

    @Override
    public double getPrice() {
        double price = 9.99d;

        if (this.city.equals("Paris")) {
            price = 6.99d;
        }

        return price;
    }
}
