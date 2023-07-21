package com.example.shop.express.mapper;

import com.example.shop.express.entity.Shipment;
import com.example.shop.express.model.request.shipment.ShipmentRequest;
import com.example.shop.express.model.response.shipment.ShipmentResponse;
import com.example.shop.express.reposervice.ContactDetailRepoService;
import com.example.shop.express.reposervice.OrderRepoService;
import com.example.shop.express.reposervice.UserRepoService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",uses = {ShipmentRequest.class, UserRepoService.class,
        OrderRepoService.class, ContactDetailRepoService.class})
public interface ShipmentMapper {

    ShipmentMapper INSTANCE= Mappers.getMapper(ShipmentMapper.class);


    @Mapping(target  ="user",source ="userId",qualifiedByName ="getUser" )
    @Mapping(target = "order",source = "orderId",qualifiedByName ="getOrder" )
    @Mapping(target = "contactDetail",source ="contactDetailId",qualifiedByName =
            "getContactDetail")
    Shipment mapShipment(ShipmentRequest shipmentRequest);

    @Mapping(target = "userId",source ="shipment.user.id")
    @Mapping(target = "orderId",source ="shipment.order.id")
    @Mapping(target = "order",source ="shipment.order" )
    ShipmentResponse mapShipmentResponse(Shipment shipment);
}
