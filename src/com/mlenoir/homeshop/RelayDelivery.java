package com.mlenoir.homeshop;

public class RelayDelivery implements Delivery {
    private int number;

    public RelayDelivery(int number) {
        this.number = number;
    }

    @Override
    public String getInfo() {
        return "Livraison en point relais";
    }

    @Override
    public double getPrice() {
        double price;

        if (this.number >= 1 && this.number <= 22) {
            price = 0.0d;
        } else if (this.number >= 23 && this.number <= 47) {
            price = 2.99d;
        } else {
            price = 4.99d;
        }

        return price;
    }
}
