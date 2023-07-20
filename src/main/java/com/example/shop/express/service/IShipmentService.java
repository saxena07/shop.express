package com.example.shop.express.service;

import com.example.shop.express.model.request.shipment.ShipmentRequest;
import com.example.shop.express.model.response.shipment.ShipmentResponse;
import org.springframework.stereotype.Service;


public interface IShipmentService {
    ShipmentResponse createShipment(final ShipmentRequest shipmentRequest);
}
