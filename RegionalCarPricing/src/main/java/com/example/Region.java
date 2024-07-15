package com.example;

import java.util.HashMap;
import java.util.Map;

public enum Region implements CarPricing {
    R1(1.2, 0.1),
    R2(1.15, 0.12),
    R3(1.1, 0.08),
    R4(1.05, 0.05),
    DEFAULT(1.1, 0.1);

    private double priceMultiplier;
    private double taxMultiplier;
    private double basePrice;
    private static final Map<String, Region> countryToRegionMap = new HashMap<>();

    static {
        countryToRegionMap.put("usa", R1);
        countryToRegionMap.put("germany", R2);
        countryToRegionMap.put("india", R3);
        countryToRegionMap.put("nigeria", R4);
    }

    Region(double priceMultiplier, double taxMultiplier) {
        this.priceMultiplier = priceMultiplier;
        this.taxMultiplier = taxMultiplier;
    }

    public static Region fromCountry(String country) {
        return countryToRegionMap.getOrDefault(country.toLowerCase().trim(), DEFAULT);
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public double calculatePrice() {
        return basePrice * priceMultiplier;
    }

    @Override
    public double calculateTax() {
        return basePrice * taxMultiplier;
    }

    @Override
    public Region getRegion() {
        return this;
    }
}
