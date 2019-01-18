package com.mlenoir.homeshop;

public class Product {
    private String name;
    private String description;
    private double price;

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Display the full description of the product.
     */
    public void look() {

    }

    /**
     * Add the product to a Bill.
     *
     * @param bill     The concerned bill.
     * @param quantity The quantity to add.
     */
    public void buy(Bill bill, Integer quantity) {

    }
}
