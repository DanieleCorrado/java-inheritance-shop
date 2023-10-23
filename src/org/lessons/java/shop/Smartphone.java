package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Smartphone extends Product{

    private long imei;
    private int storage;

    public Smartphone(String name, String description, BigDecimal price, BigDecimal vat, int storage) {
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

    // Sovrascrivo il metodo toString di Product
    @Override
    public String toString() {
        return "Name: " + getName() + ", Description: " + getDescription() + ", Price (with VAT): " + getTaxedPrice() + "Є";
    }

    // Calcolo il prezzo compreso di sconto fedeltà o tipologia prodotto
    @Override
    public BigDecimal discountedPrice() {
        if(this.storage < 32 ) {
            return getTaxedPrice().subtract((getTaxedPrice().divide(new BigDecimal(100),2, RoundingMode.UNNECESSARY)).multiply(new BigDecimal(5)));
        } else {
            return getTaxedPrice().subtract((getTaxedPrice().divide(new BigDecimal(100),2, RoundingMode.UNNECESSARY)).multiply(new BigDecimal(2)));
        }
    }
}
