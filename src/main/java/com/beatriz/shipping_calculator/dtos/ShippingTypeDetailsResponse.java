package com.beatriz.shipping_calculator.dtos;

import java.math.BigDecimal;

public record ShippingTypeDetailsResponse (
        String type,
        String description,
        BigDecimal baseFee
){}