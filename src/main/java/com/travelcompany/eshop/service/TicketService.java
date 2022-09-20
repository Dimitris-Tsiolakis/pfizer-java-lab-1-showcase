package com.travelcompany.eshop.service;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.Ticket;
import com.travelcompany.eshop.model.enumeration.PaymentMethod;

import java.math.BigDecimal;

public class TicketService {
    private PriceComputeService priceComputeService;

    public TicketService(PriceComputeService priceComputeService) {
        this.priceComputeService = priceComputeService;
    }
    public Ticket publishTicket(Customer customer, Itinerary itinerary, PaymentMethod paymentMethod) {
        BigDecimal finalPriceBigDecimal = calculatePrice(customer, itinerary.getBasePrice(), paymentMethod);
        return new Ticket(customer.getId(), itinerary.getId(), paymentMethod, finalPriceBigDecimal);
    }

    private BigDecimal calculatePrice(Customer customer, BigDecimal basePrice, PaymentMethod payment) {
        BigDecimal accumulatedExtraCharges = priceComputeService.getAccumulatedExtraCharges(customer, payment);
        BigDecimal extraChargesToBeSubtracted = basePrice.multiply(accumulatedExtraCharges);
        return basePrice.subtract(extraChargesToBeSubtracted);
    }
}
