package com.mlenoir.homeshop;

import java.util.HashMap;
import java.util.Map;

public class Bill {
    private Customer customer;
    private Map<Product, Integer> products;
    private Delivery delivery;

    public Bill(Customer customer, Delivery delivery) {
        this.customer = customer;
        this.delivery = delivery;

        this.products = new HashMap<>();
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Map<Product, Integer> getProducts() {
        return this.products;
    }

    /**
     * Get the total price for the current bill,
     * including products and delivery cost.
     *
     * @return The total price.
     */
    public double getTotal() {
        double total = 0.0d;

        for (Map.Entry<Product, Integer> entry : this.products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();

            total += product.getPrice() * quantity;
        }

        total += this.delivery.getPrice();

        return total;
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

    /**
     * Generate an output for the current bill.
     *
     * @param writer The writer object in charge to writing.
     */
    public void generate(Writer writer) {
        writer.start();

        writer.writeLine("HomeShop compagnie");
        writer.writeLine("1, Place Charles de Gaulle, 75008 Paris");

        writer.writeLine("");

        writer.writeLine("Facture à l'attention de :");
        writer.writeLine(this.customer.getFullname());
        writer.writeLine(this.customer.getAddress());

        writer.writeLine("");

        writer.writeLine("Mode de livraison : " + this.delivery.getInfo().toLowerCase());

        writer.writeLine("");

        writer.writeLine("Produits :");
        writer.writeLine("-----------------------------------------------------");

        for (Map.Entry<Product, Integer> entry : this.products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();

            writer.writeLine(product.getName() + " - " + product.getPrice() + "€ - " + quantity + " unité(s)");
            writer.writeLine(product.getDescription());

            writer.writeLine("");
        }

        writer.writeLine("Livraison : " + this.delivery.getPrice() + "€");

        writer.writeLine("-----------------------------------------------------");

        writer.writeLine("Total : " + this.getTotal() + "€");

        writer.stop();
    }
}
