package com.beatriz.shipping_calculator.dtos;

import java.math.BigDecimal;

public record ShippingResponse(
        BigDecimal baseValue,
        String destination,
        String shippingType,
        BigDecimal shippingCost
) {}
