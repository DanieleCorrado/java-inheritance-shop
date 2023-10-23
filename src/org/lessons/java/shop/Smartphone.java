package org.lessons.java.shop;

import java.util.Random;

public class Smartphone extends Product{

    private long imei;
    private int storage;

    public Smartphone(String name, String description, double price, double vat, int storage) {
        super(name, description, price, vat);

        Random randomNumber = new Random();
        this.imei = randomNumber.nextLong(1, 999);
        this.storage = storage;
    }

    // METODI
    public long getImei() {
        return imei;
    }

    public void setImei(long imei) {
        this.imei = imei;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Description: " + getDescription() + ", Price (with VAT): " + getTaxedPrice() + "Є";
    }

    @Override
    public double discountedPrice() {
        if(this.storage < 32 ) {
            return getTaxedPrice() - ((getTaxedPrice() / 100) * 5);
        } else {
            return getTaxedPrice() - ((getTaxedPrice() / 100) * 2);
        }
    }
}
