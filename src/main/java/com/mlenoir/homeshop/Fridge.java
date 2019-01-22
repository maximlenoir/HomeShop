package com.mlenoir.homeshop;

public class Fridge extends Product {
    private int liter;
    private boolean freezer;

    public Fridge(String name, String description, double price, int liter, boolean freezer) {
        super(name, description, price);

        this.liter = liter;
        this.freezer = freezer;
    }

    public int getLiter() {
        return this.liter;
    }

    public boolean isFreezer() {
        return this.freezer;
    }
}
