package com.beatriz.shipping_calculator.dtos;

import java.math.BigDecimal;

public record UpdatedShippingResponse(
        String type,
        BigDecimal baseFee,
        BigDecimal percentageFee
) { }
