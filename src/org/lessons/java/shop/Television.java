package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Television extends Product{

    private int inch;
    private boolean isSmart;

    public Television(String name, String description, BigDecimal price, BigDecimal vat, int inch, boolean isSmart) {
        super(name, description, price, vat);

        this.inch = inch;
        this.isSmart = isSmart;
    }

    // METODI

    public int getInch() {
        return inch;
    }

    public void setInch(int inch) {
        this.inch = inch;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void setSmart(boolean smart) {
        isSmart = smart;
    }

    // Sovrascrivo il metodo toString di Product
    @Override
    public String toString() {
        return "Name: " + getName() + ", Description: " + getDescription() + ", Price (with VAT): " + getTaxedPrice() + "Є";
    }

    // Calcolo il prezzo compreso di sconto fedeltà o tipologia prodotto
    @Override
    public BigDecimal discountedPrice() {
        if(!this.isSmart ) {
            return getTaxedPrice().subtract((getTaxedPrice().divide(new BigDecimal(100),2, RoundingMode.UNNECESSARY)).multiply(new BigDecimal(10)));
        } else {
            return getTaxedPrice().subtract((getTaxedPrice().divide(new BigDecimal(100),2, RoundingMode.UNNECESSARY)).multiply(new BigDecimal(2)));
        }
    }
}
