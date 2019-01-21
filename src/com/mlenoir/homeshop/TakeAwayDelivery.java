package com.mlenoir.homeshop;

public class TakeAwayDelivery implements Delivery {
    @Override
    public String getInfo() {
        return "Retrait gratuit à l'entrepôt dans Paris";
    }

    @Override
    public double getPrice() {
        return 0.0d;
    }
}
