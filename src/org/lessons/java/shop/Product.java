package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Product {

    // ATTRIBUTI

    private int code;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal vat;

    // COSTRUTTORI

    public Product(String name, String description, BigDecimal price, BigDecimal vat) {
        Random randomNumber = new Random();
        this.code = randomNumber.nextInt(1, 999);
        this.name = name;
        this.description = description;
        this.price = price;
        this.vat = vat;
    }

    // METODI

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public String fullName() {
        return codePadLeft(this.code) + "-" + this.name.replace(" ", "-");
    }


    // Calcolo il prezzo compreso di IVA
    public BigDecimal getTaxedPrice() {
        return this.price.add((this.price.divide(new BigDecimal(100),2, RoundingMode.UNNECESSARY)).multiply(this.vat));
    }

    // Calcolo il prezzo compreso di sconto fedeltà
    public BigDecimal discountedPrice() {
        return getTaxedPrice().subtract((this.getTaxedPrice().divide(new BigDecimal(100), 2, RoundingMode.UNNECESSARY)).multiply(new BigDecimal(2)));
    }

    private String codePadLeft(int code) {
        StringBuilder codeString = new StringBuilder();
        codeString.append(code);
        int length= codeString.length();

        if(codeString.length() >= 8) {
            return Integer.toString(code);
        } else {
            for (int i = 0; i < 8 - length; i++) {
                codeString.insert(0,'0');
            }
            return codeString.toString();
        }
    }

    // Sovrascrivo il metodo toString di default di java
    @Override
    public String toString() {
        return "Name: " + getName();
    }

}
