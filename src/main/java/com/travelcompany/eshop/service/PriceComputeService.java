package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.enumeration.PaymentMethod;

import java.math.BigDecimal;

public class PriceComputeService {
    public BigDecimal getAccumulatedExtraCharges(Customer customer, PaymentMethod paymentMethod) {
        return BigDecimal.valueOf(customer.getCategory().getDiscount()).add(BigDecimal.valueOf(paymentMethod.getDiscount()));
    }
}
