package com.mlenoir.homeshop;

public class DirectDelivery implements Delivery {
    @Override
    public double getPrice() {
        return 4.99d;
    }
}
