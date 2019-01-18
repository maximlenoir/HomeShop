package com.mlenoir.homeshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RelayDeliveryTest {
    @Test
    public void Given_FreeRelay_When_GettingDeliveryPrice_Then_Get0e() {
        Delivery delivery = new RelayDelivery(5);

        double actualPrice = delivery.getPrice();

        assertEquals(0.0d, actualPrice, 0.01d);
    }

    @Test
    public void Given_LowPriceRelay_When_GettingDeliveryPrice_Then_Get2e99() {
        Delivery delivery = new RelayDelivery(27);

        double actualPrice = delivery.getPrice();

        assertEquals(2.99d, actualPrice, 0.01d);
    }

    @Test
    public void Given_HighPriceRelay_When_GettingDeliveryPrice_Then_Get4e99() {
        Delivery delivery = new RelayDelivery(52);

        double actualPrice = delivery.getPrice();

        assertEquals(4.99d, actualPrice, 0.01d);
    }
}
