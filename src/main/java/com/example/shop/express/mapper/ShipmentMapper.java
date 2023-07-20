package com.example.shop.express.mapper;

import com.example.shop.express.entity.Shipment;
import com.example.shop.express.model.request.shipment.ShipmentRequest;
import com.example.shop.express.model.response.shipment.ShipmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ShipmentMapper {

    ShipmentMapper INSTANCE= Mappers.getMapper(ShipmentMapper.class);

    Shipment mapShipment(ShipmentRequest shipmentRequest);

    ShipmentResponse mapShipmentResponse(Shipment shipment);
}
