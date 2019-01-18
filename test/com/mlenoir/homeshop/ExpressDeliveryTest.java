package com.mlenoir.homeshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressDeliveryTest {
    @Test
    public void Given_AnyRegionExceptParisAsLocation_When_GettingDeliveryPrice_Then_Get9e99() {
        Delivery delivery = new ExpressDelivery("Bordeaux");

        assertEquals(9.99d, delivery.getPrice(), 0.01d);
    }
    @Test
    public void Given_ParisAsLocation_When_GettingDeliveryPrice_Then_Get6e99() {
        Delivery delivery = new ExpressDelivery("Paris");

        assertEquals(6.99d, delivery.getPrice(), 0.01d);
    }
}
