package com.beatriz.shipping_calculator.strategies;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import static java.math.BigDecimal.valueOf;

@Service("standard")
public class StandardShipping implements ShippingStrategy{

    @Override
    public BigDecimal calculate(BigDecimal baseValue, String destination){
        BigDecimal value = valueOf(15).add(
                (valueOf(0.02).multiply(baseValue))
        );
        if ("international".equalsIgnoreCase(destination)){
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
        return "Frete padrão com prazo estendido";
    }

    @Override
    public BigDecimal getBaseFee() {
        return new BigDecimal("5.00");
    }

}
