package com.travelcompany.eshop.model;

import com.travelcompany.eshop.model.enumeration.PaymentMethod;

import java.math.BigDecimal;

public class Ticket extends BaseEntity {
    private long passengerId;
    private long itineraryId;
    private PaymentMethod paymentMethod;
    private BigDecimal paymentAmount;

    public Ticket(long passengerId, long itineraryId, PaymentMethod paymentMethod, BigDecimal paymentAmount) {
        this.passengerId = passengerId;
        this.itineraryId = itineraryId;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "passengerId=" + passengerId +
                ", itineraryId=" + itineraryId +
                ", paymentMethod=" + paymentMethod +
                ", paymentAmount=" + paymentAmount +
                "} " + super.toString();
    }
}
