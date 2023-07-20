package com.example.shop.express.service;

import com.example.shop.express.entity.Shipment;
import com.example.shop.express.mapper.ShipmentMapper;
import com.example.shop.express.model.request.shipment.ShipmentRequest;
import com.example.shop.express.model.response.shipment.ShipmentResponse;
import com.example.shop.express.reposervice.ContactDetailRepoService;
import com.example.shop.express.reposervice.OrderRepoService;
import com.example.shop.express.reposervice.ShipmentRepoService;
import com.example.shop.express.reposervice.UserRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService implements IShipmentService {

    @Autowired
    private ShipmentRepoService shipmentRepoService;

    @Autowired
    private UserRepoService userRepoService;

    @Autowired
    private OrderRepoService orderRepoService;

    @Autowired
    private ContactDetailRepoService contactDetailRepoService;

    @Autowired
    private ShipmentMapper shipmentMapper;

    @Override
    public ShipmentResponse createShipment(final ShipmentRequest shipmentRequest) {

        Shipment shipment = shipmentMapper.mapShipment(shipmentRequest);

        //scope for exception
        shipment.setUser(userRepoService.getDetails(shipmentRequest.getUserId()));

        shipment.setOrder(orderRepoService.fetchOrderById(shipmentRequest.getOrderId()));

        shipment.setContactDetail(
                contactDetailRepoService.fetchContactDetail(shipmentRequest.getContactDetailId()));


        return shipmentMapper.mapShipmentResponse(shipmentRepoService.saveShipment(shipment));
    }

    @Override
    public ShipmentResponse fetchShipment(final Integer id)
    {
        return shipmentMapper.mapShipmentResponse(shipmentRepoService.fetchById(id));
    }
}
