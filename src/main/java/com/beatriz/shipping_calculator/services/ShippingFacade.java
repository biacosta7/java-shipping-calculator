package com.beatriz.shipping_calculator.services;

import com.beatriz.shipping_calculator.dtos.ShippingRequest;
import com.beatriz.shipping_calculator.dtos.ShippingResponse;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ShippingFacade {
    private final ShippingService shippingService;

    public ShippingFacade(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public ShippingResponse calculateShipping(ShippingRequest request){
        return shippingService.calculateShipping(request);
    }

    public Set<String> listShippingTypes(){
        return shippingService.listShippingTypes();
    }
}
