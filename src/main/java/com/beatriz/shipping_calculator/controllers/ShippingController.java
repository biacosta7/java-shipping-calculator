package com.beatriz.shipping_calculator.controllers;

import com.beatriz.shipping_calculator.dtos.ShippingRequest;
import com.beatriz.shipping_calculator.dtos.ShippingResponse;
import com.beatriz.shipping_calculator.services.ShippingFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate-shipping")
public class ShippingController {
    private final ShippingFacade shippingFacade;

    public ShippingController(ShippingFacade shippingFacade) {
        this.shippingFacade = shippingFacade;
    }

    @PostMapping
    public ShippingResponse post(@RequestBody ShippingRequest shippingRequest){
        return shippingFacade.calculateShipping(shippingRequest);
    }
}
