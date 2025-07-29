package com.beatriz.shipping_calculator.strategies;

import java.math.BigDecimal;

public interface ShippingStrategy {
    public abstract BigDecimal calculate(BigDecimal baseValue, String destination);
    public abstract String getType();
}
