package com.beatriz.shipping_calculator.controllers;

import com.beatriz.shipping_calculator.dtos.*;
import com.beatriz.shipping_calculator.services.ShippingFacade;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/shipping-types/{type}")
    public ShippingTypeDetailsResponse getShippingTypeDetails(@PathVariable String type){
        return shippingFacade.getShippingTypeDetails(type);
    }

    @PutMapping("/update/{type}")
    public ResponseEntity<UpdatedShippingResponse> updateShippingType(
            @PathVariable String type,
            @RequestBody UpdateShippingTypeRequest request
    ) {
        shippingFacade.updateShippingType(type, request.baseFee(), request.percentageFee());
        return ResponseEntity.ok(new UpdatedShippingResponse(
                type,
                request.baseFee(),
                request.percentageFee()
        ));
    }

}
