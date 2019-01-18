package com.mlenoir.homeshop;

import java.util.Map;

public class Bill {
    private Customer customer;
    private Map<Product, Integer> products;

    public Bill(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Map<Product, Integer> getProducts() {
        return this.products;
    }

    /**
     * Add a product with a quantity in the bill.
     *
     * @param product  The product to add.
     * @param quantity The quantity of the product to add.
     */
    public void addProduct(Product product, Integer quantity) {
        this.products.put(product, quantity);
    }
}
