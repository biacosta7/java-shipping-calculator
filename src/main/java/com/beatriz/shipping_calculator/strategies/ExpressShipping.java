package com.beatriz.shipping_calculator.strategies;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import static java.math.BigDecimal.valueOf;

@Service("express")
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

    @Override
    public String getType() {
        return "express";
    }
}
