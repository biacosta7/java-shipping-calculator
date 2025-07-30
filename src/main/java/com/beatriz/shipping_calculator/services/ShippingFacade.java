package com.beatriz.shipping_calculator.services;

import com.beatriz.shipping_calculator.dtos.ShippingRequest;
import com.beatriz.shipping_calculator.dtos.ShippingResponse;
import com.beatriz.shipping_calculator.dtos.ShippingTypeDetailsResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
public class ShippingFacade {
    private final ShippingService shippingService;

    public ShippingFacade(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public ShippingResponse calculateShipping(ShippingRequest request) {
        return shippingService.calculateShipping(request);
    }

    public Set<String> listShippingTypes() {
        return shippingService.listShippingTypes();
    }

    public ShippingTypeDetailsResponse getShippingTypeDetails(String type) {
        return shippingService.getShippingTypeDetails(type);
    }

    public void updateShippingType(String type, BigDecimal baseFee, BigDecimal percentageFee) {
        shippingService.updateShippingType(type, baseFee, percentageFee);
    }

}
