package com.beatriz.shipping_calculator.controllers;

import com.beatriz.shipping_calculator.dtos.ShippingRequest;
import com.beatriz.shipping_calculator.dtos.ShippingResponse;
import com.beatriz.shipping_calculator.services.ShippingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate-shipping")
public class ShippingController {
    private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @PostMapping
    public ShippingResponse post(@RequestBody ShippingRequest shippingRequest){
        return shippingService.calculateShipping(shippingRequest);
    }
}
