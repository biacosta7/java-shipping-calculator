package com.beatriz.shipping_calculator.controllers;

import com.beatriz.shipping_calculator.dtos.ShippingRequest;
import com.beatriz.shipping_calculator.dtos.ShippingResponse;
import com.beatriz.shipping_calculator.services.ShippingFacade;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping
public class ShippingController {
    private final ShippingFacade shippingFacade;

    public ShippingController(ShippingFacade shippingFacade) {
        this.shippingFacade = shippingFacade;
    }

    @PostMapping("/calculate-shipping")
    public ShippingResponse post(@RequestBody ShippingRequest shippingRequest){
        return shippingFacade.calculateShipping(shippingRequest);
    }

    @GetMapping("/shipping-types")
    public Set<String> listShippingTypes(){
        return shippingFacade.listShippingTypes();
    }
}
