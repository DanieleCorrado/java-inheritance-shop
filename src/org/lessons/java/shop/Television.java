package org.lessons.java.shop;

public class Television extends Product{

    private int inch;
    private boolean isSmart;

    public Television(String name, String description, double price, double vat, int inch, boolean isSmart) {
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

    @Override
    public String toString() {
        return "Name: " + getName() + ", Description: " + getDescription() + ", Price (with VAT): " + getTaxedPrice() + "Є";
    }

    @Override
    public double discountedPrice() {
        if(!this.isSmart ) {
            return getTaxedPrice() - ((getTaxedPrice() / 100) * 10);
        } else {
            return getTaxedPrice() - ((getTaxedPrice() / 100) * 2);
        }
    }
}
