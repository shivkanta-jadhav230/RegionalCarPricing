package com.example;

import java.util.Scanner;

public class CarPricingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the country of origin: ");
        String country = scanner.nextLine().trim();

        System.out.print("Enter the base price of the car: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid base price entered. Please enter a numeric value.");
            scanner.close();
            return;
        }
        double basePrice = scanner.nextDouble();

        Region region = Region.fromCountry(country);
        region.setBasePrice(basePrice);

        double finalPrice = region.calculatePrice();
        double tax = region.calculateTax();

        System.out.println("\nCalculation Result:");
        System.out.println("-------------------");
        System.out.println("Country: " + country);
        System.out.println("Region: " + region.getRegion());
        System.out.println("Base Price: $" + basePrice);
        System.out.println("Final Price: $" + finalPrice);
        System.out.println("Tax: $" + tax);

        scanner.close();
    }
}
