package com.example;

public interface CarPricing {
    double getBasePrice();
    double calculatePrice();
    double calculateTax();
    Region getRegion();
}
