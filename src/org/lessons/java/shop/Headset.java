package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Headset extends Product {

    private String color;
    private boolean isWireless;

    public Headset(String name, String description, BigDecimal price, BigDecimal vat, String color, boolean isWireless) {
        super(name, description, price, vat);

        this.color = color;
        this.isWireless = isWireless;
    }

    // METODI

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public void setWireless(boolean wireless) {
        isWireless = wireless;
    }

    // Sovrascrivo il metodo toString di Product
    @Override
    public String toString() {
        return "Name: " + getName() + ", Description: " + getDescription() + ", Price (with VAT): " + getTaxedPrice() + "Є";
    }

    // Calcolo il prezzo compreso di sconto fedeltà o tipologia prodotto
    @Override
    public BigDecimal discountedPrice() {
        if(!this.isWireless) {
            return getTaxedPrice().subtract((getTaxedPrice().divide(new BigDecimal(100),2, RoundingMode.UNNECESSARY)).multiply(new BigDecimal(7)));
        } else {
            return getTaxedPrice().subtract((getTaxedPrice().divide(new BigDecimal(100),2, RoundingMode.UNNECESSARY)).multiply(new BigDecimal(2)));
        }
    }
}