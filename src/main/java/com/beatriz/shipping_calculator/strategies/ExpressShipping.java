package com.beatriz.shipping_calculator.strategies;

import java.math.BigDecimal;
import java.util.Objects;

import static java.math.BigDecimal.valueOf;

public class ExpressShipping implements ShippingStrategy{
    @Override
    public BigDecimal calculate(BigDecimal baseValue, String destination){
        BigDecimal value = valueOf(20).add(
                (valueOf(0.03).multiply(baseValue))
        );
        if ("international".equalsIgnoreCase(destination)){
            value = value.add(valueOf(30));
        }
        if(baseValue.compareTo(valueOf(50)) < 0){
            value = valueOf(50);
        }

        return value;
    }
}
