package com.beatriz.shipping_calculator.services;

import com.beatriz.shipping_calculator.dtos.ShippingRequest;
import com.beatriz.shipping_calculator.dtos.ShippingResponse;
import com.beatriz.shipping_calculator.dtos.ShippingTypeDetailsResponse;
import com.beatriz.shipping_calculator.strategies.ShippingStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ShippingService {
    private final Map<String, ShippingStrategy> strategyMap = new HashMap<>();

    public ShippingService(List<ShippingStrategy> strategies) {
        for (ShippingStrategy strategy : strategies) {
            strategyMap.put(strategy.getType(), strategy);
        }
    }

    public ShippingResponse calculateShipping(ShippingRequest shippingRequest){
        ShippingStrategy strategy = strategyMap.get(shippingRequest.shippingType().toLowerCase());
        if (strategy == null) {
            throw new IllegalArgumentException("Invalid shipping type: " + shippingRequest.shippingType());
        }

        BigDecimal shippingCost = strategy.calculate(shippingRequest.baseValue(), shippingRequest.destination());

        return new ShippingResponse(
                shippingRequest.baseValue(),
                shippingRequest.destination(),
                shippingRequest.shippingType(),
                shippingCost
        );

    }

    public Set<String> listShippingTypes(){
        return strategyMap.keySet();
    }

    public ShippingTypeDetailsResponse getShippingTypeDetails(String type){
        ShippingStrategy strategy = strategyMap.get(type.toLowerCase());
        if (strategy == null) {
            throw new IllegalArgumentException("Invalid shipping type: " + type);
        }

        return new ShippingTypeDetailsResponse(
                strategy.getType(),
                strategy.getDescription(),
                strategy.getBaseFee()
        );
    }
}
