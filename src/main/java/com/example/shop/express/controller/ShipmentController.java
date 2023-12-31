package com.example.shop.express.controller;

import com.example.shop.express.model.request.shipment.ShipmentRequest;
import com.example.shop.express.model.response.shipment.ShipmentResponse;
import com.example.shop.express.service.IShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/shipments")
public class ShipmentController {

    @Autowired
    private IShipmentService shipmentService;

    /***
     *
     * @param shipmentRequest
     * @return
     */
    @PostMapping
    public ShipmentResponse createShipment(@Valid @RequestBody final ShipmentRequest shipmentRequest)
    {
        return shipmentService.createShipment(shipmentRequest);
    }

    @GetMapping(value = "/{id}")
    public  ShipmentResponse fetchShipment(@PathVariable final Integer id)
    {
       return shipmentService.fetchShipment(id);
    }
}
