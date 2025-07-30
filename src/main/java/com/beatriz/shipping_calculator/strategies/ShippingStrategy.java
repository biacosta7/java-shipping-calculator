package com.beatriz.shipping_calculator.strategies;

import java.math.BigDecimal;

public interface ShippingStrategy {
    public abstract BigDecimal calculate(BigDecimal baseValue, String destination);
    public abstract String getType();

    default String getDescription() {
        return "Shipping type: " + getType();
    }

    default BigDecimal getBaseFee() {
        return BigDecimal.ZERO;
    }

    default BigDecimal getPercentageFee() {
        return BigDecimal.ZERO;
    }

    public abstract void updateFees(BigDecimal baseFee, BigDecimal percentageFee);
}
