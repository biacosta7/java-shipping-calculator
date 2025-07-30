package com.beatriz.shipping_calculator.strategies;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import static java.math.BigDecimal.valueOf;

@Service("standard")
public class StandardShipping implements ShippingStrategy{
    private BigDecimal baseFee;
    private BigDecimal percentageFee;

    @Override
    public BigDecimal calculate(BigDecimal baseValue, String destination) {
        BigDecimal value = getBaseFee().add(baseValue.multiply(getPercentageFee()));

        if ("international".equalsIgnoreCase(destination)) {
            value = value.add(valueOf(20));
        }

        return value;
    }


    @Override
    public String getType() {
        return "standard";
    }

    @Override
    public String getDescription() {
        return "Standard shipping with extended delivery time";
    }

    @Override
    public BigDecimal getBaseFee() {
        return (this.baseFee == null) ? new BigDecimal("5.00") : this.baseFee;
    }

    @Override
    public BigDecimal getPercentageFee() {
        return (this.percentageFee == null) ? new BigDecimal("0.02") : this.percentageFee;
    }

    @Override
    public void updateFees(BigDecimal baseFee, BigDecimal percentageFee) {
        this.baseFee = baseFee;
        this.percentageFee = percentageFee;
    }


}
