package com.example.shop.express.reposervice;

import com.example.shop.express.entity.Shipment;
import com.example.shop.express.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentRepoService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    public Shipment saveShipment(final Shipment shipment) {
        return shipmentRepository.save(shipment);
    }
}
