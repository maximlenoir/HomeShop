package com.mlenoir.homeshop;

public class DirectDelivery implements Delivery {
    @Override
    public String getInfo() {
        return "Livraison à domicile";
    }

    @Override
    public double getPrice() {
        return 4.99d;
    }
}
