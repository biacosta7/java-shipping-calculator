package com.beatriz.shipping_calculator.services;

import com.beatriz.shipping_calculator.dtos.ShippingRequest;
import com.beatriz.shipping_calculator.dtos.ShippingResponse;
import com.beatriz.shipping_calculator.strategies.ExpressShipping;
import com.beatriz.shipping_calculator.strategies.ShippingStrategy;
import com.beatriz.shipping_calculator.strategies.StandardShipping;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShippingService {
    private final Map<String, ShippingStrategy> strategyMap = new HashMap<>();

    public ShippingService(List<ShippingStrategy> strategies) {
        for (ShippingStrategy strategy : strategies) {
            strategyMap.put(strategy.getType(), strategy);
        }
    }

    public ShippingResponse calculateShipping(ShippingRequest shippingData){
        ShippingStrategy strategy = strategyMap.get(shippingData.shippingType().toLowerCase());
        if (strategy == null) {
            throw new IllegalArgumentException("Tipo de frete inválido: " + shippingData.shippingType());
        }

        BigDecimal shippingCost = strategy.calculate(shippingData.baseValue(), shippingData.destination());

        return new ShippingResponse(
                shippingData.baseValue(),
                shippingData.destination(),
                shippingData.shippingType(),
                shippingCost
        );

    }
}
