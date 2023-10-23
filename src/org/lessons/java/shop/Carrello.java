package org.lessons.java.shop;

import java.math.BigDecimal;
import java.util.Scanner;

public class Carrello {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int productType;
        int productsNumber;

        System.out.print("How many products do you want to add? ");
        productsNumber = scanner.nextInt();
        scanner.nextLine();

        Product[] products = new Product[productsNumber];

        for (int i = 0; i < productsNumber; i++) {
            System.out.println("1 - Smartphone");
            System.out.println("2 - Television");
            System.out.println("3 - Headset");
            System.out.print("What type of product do you want to add? ");
            productType = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter the name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Description: ");
            String description = scanner.nextLine();
            System.out.print("Enter price: ");
            BigDecimal price = new BigDecimal(scanner.nextLine());
            System.out.print("Enter VAT: ");
            BigDecimal vat =  new BigDecimal(scanner.nextLine());

            if (productType == 1) {
                System.out.print("Enter the storage: ");
                int storage = Integer.parseInt(scanner.nextLine());
                Smartphone smartphone = new Smartphone(name,description,price,vat,storage);
                products[i] = smartphone;
            } else if (productType == 2) {
            System.out.print("Enter the inches: ");
                int inches = Integer.parseInt(scanner.nextLine());
                System.out.print("Is a smart tv? (true, false): ");
                boolean isSmart = Boolean.parseBoolean(scanner.nextLine());
                Television television  = new Television(name,description,price,vat,inches, isSmart);
                products[i] = television;

            } else if (productType == 3){
                System.out.print("Enter the color: ");
                String color = scanner.nextLine();
                System.out.print("Is a wireless headset? (true, false): ");
                boolean iswireless = Boolean.parseBoolean(scanner.nextLine());
                Headset headset = new Headset(name,description,price,vat,color,iswireless);
                products[i] = headset;
            }

        }

        System.out.println("All products added");

        System.out.print("Do you have a loyalty card? (true, false) ");
        boolean fidelityCard = Boolean.parseBoolean(scanner.nextLine());

        BigDecimal totalCart = new BigDecimal(0);
        System.out.println("The cart contains the following products: ");
        for (int i = 0; i < products.length; i++) {

            System.out.println(products[i]);

            if (fidelityCard) {
                System.out.println("Discount applied the new price is: " + products[i].discountedPrice() + "Є");
                totalCart = totalCart.add(products[i].discountedPrice());
            } else {
                totalCart = totalCart.add(products[i].getTaxedPrice());
            }

        }
        System.out.print("The total price is: " + totalCart + "Є");

    }
}
