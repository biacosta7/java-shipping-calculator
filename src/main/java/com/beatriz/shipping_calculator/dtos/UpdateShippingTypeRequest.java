package com.beatriz.shipping_calculator.dtos;

import java.math.BigDecimal;

public record UpdateShippingTypeRequest(
        BigDecimal baseFee,
        BigDecimal percentageFee
) {}
