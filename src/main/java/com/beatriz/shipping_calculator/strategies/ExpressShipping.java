package com.beatriz.shipping_calculator.strategies;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import static java.math.BigDecimal.valueOf;

@Service("express")
public class ExpressShipping implements ShippingStrategy{
    @Override
    public BigDecimal calculate(BigDecimal baseValue, String destination){
        BigDecimal value = valueOf(25).add(
                (valueOf(0.05).multiply(baseValue))
        );
        if ("international".equalsIgnoreCase(destination)){
            value = value.add(valueOf(30));
        }
        if(baseValue.compareTo(valueOf(100)) < 0){
            value = valueOf(60);
        }

        return value;
    }

    @Override
    public String getType() {
        return "express";
    }

    @Override
    public String getDescription() {
        return "Frete expresso com entrega rápida";
    }

    @Override
    public BigDecimal getBaseFee() {
        return new BigDecimal("10.00");
    }
}
