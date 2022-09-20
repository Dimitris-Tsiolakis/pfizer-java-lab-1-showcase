package com.travelcompany.eshop.model.enumeration;

public enum CustomerCategory {
    INDIVIDUAL(-0.20),
    BUSINESS(0.10);

    private final double discount;

    CustomerCategory(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
