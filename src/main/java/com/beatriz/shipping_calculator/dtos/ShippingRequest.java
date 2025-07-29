package com.beatriz.shipping_calculator.dtos;

import java.math.BigDecimal;

public record ShippingRequest(
        BigDecimal baseValue,
        String destination,
        String shippingType
) {}
