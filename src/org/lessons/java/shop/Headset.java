package org.lessons.java.shop;

public class Headset extends Product {

    private String color;
    private boolean isWireless;

    public Headset(String name, String description, double price, double vat, String color, boolean isWireless) {
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
    public double discountedPrice() {
        if(!this.isWireless) {
            return getTaxedPrice() - ((getTaxedPrice() / 100) * 7);
        } else {
            return getTaxedPrice() - ((getTaxedPrice() / 100) * 2);
        }
    }
}