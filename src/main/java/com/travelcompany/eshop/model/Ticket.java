package com.travelcompany.eshop.model;

import com.travelcompany.eshop.model.enumeration.PaymentMethod;

import java.math.BigDecimal;

public class Ticket extends BaseEntity {
    private long passengerId;
    private long itineraryId;
    private PaymentMethod paymentMethod;
    private BigDecimal paymentAmount;
}
