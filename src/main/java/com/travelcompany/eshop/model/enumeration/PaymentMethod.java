package com.travelcompany.eshop.model.enumeration;

public enum PaymentMethod {
    CASH(0),
    CREDIT(0.10);

    private final double discount;

    PaymentMethod(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
