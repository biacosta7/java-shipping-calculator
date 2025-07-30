package com.beatriz.shipping_calculator.strategies;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import static java.math.BigDecimal.valueOf;

@Service("express")
public class ExpressShipping implements ShippingStrategy{
    private BigDecimal baseFee;
    private BigDecimal percentageFee;

    @Override
    public BigDecimal calculate(BigDecimal baseValue, String destination){
        BigDecimal value = getBaseFee().add(
                (getPercentageFee().multiply(baseValue))
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
        return "Express shipping with fast delivery";
    }

    @Override
    public BigDecimal getBaseFee() {
        return (this.baseFee == null) ? new BigDecimal("10.00") : this.baseFee;
    }

    @Override
    public BigDecimal getPercentageFee() {
        return (this.percentageFee == null) ? new BigDecimal("0.05") : this.percentageFee;
    }

    @Override
    public void updateFees(BigDecimal baseFee, BigDecimal percentageFee) {
        this.baseFee = baseFee;
        this.percentageFee = percentageFee;
    }

}
