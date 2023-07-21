package com.example.shop.express.mapper;

import com.example.shop.express.entity.OrderItem;
import com.example.shop.express.model.request.orderItem.OrderItemRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderItemMapper {

    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);


    public OrderItem mapOrderItemRequest(OrderItemRequest orderItemRequest);

}
