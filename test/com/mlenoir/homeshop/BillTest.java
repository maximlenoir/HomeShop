package com.mlenoir.homeshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BillTest {
    private String output;

    private Writer writerMock = new Writer() {
        @Override
        public void start() {
            output = "";
        }

        @Override
        public void writeLine(String line) {
            output += line + "%n";
        }

        @Override
        public void stop() {

        }
    };

    private Customer customer = new Customer("Maxime LENOIR", "1, Rue de la Paix, 59000 Lille");

    private Delivery freeDelivery = new TakeAwayDelivery();
    private Delivery lowCostDelivery = new RelayDelivery(27);

    private Product philipsSenseo = new Product("Philips HD7866/61", "Philips SENSEO Quadrante, Noir - 1 ou 2 tasses", 79.99d);
    private Product samsungTv = new Television("TV Samsung UE49MU6292", "Smart TV LED incurvée 49\"", 599d, 49, "LED");
    private Product bekoFridge = new Fridge("BEKO TSE 1042 F", "Réfrigérateur BEKO 130L - Classe A+ - Blanc", 189d, 130, false);

    @Test
    public void Given_ThreeProductsAndFreeDelivery_When_GettingTotal_Then_GetGoodTotal() {
        Bill bill = new Bill(this.customer, this.freeDelivery);

        bill.addProduct(this.philipsSenseo, 1);
        bill.addProduct(this.samsungTv, 1);
        bill.addProduct(this.bekoFridge, 1);

        double actualTotal = bill.getTotal();

        assertEquals(867.99d, actualTotal);
    }

    @Test
    public void Given_TwoProductsAndLowCostDelayDelivery_When_GeneratingBill_Then_GetCorrectOutput() {
        Bill bill = new Bill(this.customer, this.lowCostDelivery);

        bill.addProduct(this.philipsSenseo, 1);
        bill.addProduct(this.samsungTv, 1);

        bill.generate(this.writerMock);

        String[] outputLines = this.output.split("%n");

        assertEquals(20, outputLines.length);

        assertEquals("HomeShop compagnie", outputLines[0]);
        assertEquals("1, Place Charles de Gaulle, 75008 Paris", outputLines[1]);
        assertEquals("Facture à l'attention de :", outputLines[3]);
        assertEquals("Maxime LENOIR", outputLines[4]);
        assertEquals("1, Rue de la Paix, 59000 Lille", outputLines[5]);
        assertEquals("Mode de livraison : livraison en point relais", outputLines[7]);
        assertEquals("Produits :", outputLines[9]);
        assertEquals("Philips HD7866/61 - 79.99€ - 1 unité(s)", outputLines[11]);
        assertEquals("Philips SENSEO Quadrante, Noir - 1 ou 2 tasses", outputLines[12]);
        assertEquals("TV Samsung UE49MU6292 - 599.0€ - 1 unité(s)", outputLines[14]);
        assertEquals("Smart TV LED incurvée 49\"", outputLines[15]);
        assertEquals("Livraison : 2.99€", outputLines[17]);
        assertEquals("Total : 681.98€", outputLines[19]);
    }
}
