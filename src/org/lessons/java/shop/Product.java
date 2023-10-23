package org.lessons.java.shop;

import java.util.Random;

public class Product {

    // ATTRIBUTI

    private int code;
    private String name;
    private String description;
    private double price;
    private double vat;

    // COSTRUTTORI

    public Product(String name, String description, double price, double vat) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public String fullName() {
        return codePadLeft(this.code) + "-" + this.name.replace(" ", "-");
    }

    public double getTaxedPrice() {
        return this.price + ((this.price / 100) * this.vat);
    }

    public double discountedPrice() {
        return getTaxedPrice() - ((getTaxedPrice() / 100) * 2);
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
    @Override
    public String toString() {
        return "Name: " + getName();
    }

}
