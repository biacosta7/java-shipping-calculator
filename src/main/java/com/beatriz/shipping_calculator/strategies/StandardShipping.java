package com.beatriz.shipping_calculator.strategies;

import java.math.BigDecimal;
import java.util.Objects;

import static java.math.BigDecimal.valueOf;

public class StandardShipping implements ShippingStrategy{

    @Override
    public BigDecimal calculate(BigDecimal baseValue, String destination){
        BigDecimal value = (BigDecimal.TEN).add(
                                (valueOf(0.01).multiply(baseValue))
                            );
        if ("international".equalsIgnoreCase(destination)){
            value = value.add(valueOf(15));
        }

        return value;
    }


}
