package com.beatriz.shipping_calculator.strategies;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import static java.math.BigDecimal.valueOf;

@Service("standard")
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

    @Override
    public String getType() {
        return "standard";
    }

}
