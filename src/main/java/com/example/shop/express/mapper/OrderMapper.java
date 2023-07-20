package com.example.shop.express.mapper;


import com.example.shop.express.entity.Order;
import com.example.shop.express.entity.Product;
import com.example.shop.express.model.request.order.CreateOrderRequest;
import com.example.shop.express.model.request.product.AddProductRequest;
import com.example.shop.express.model.response.CreateOrderResponse;
import com.example.shop.express.model.response.order.FetchOrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);


    List<FetchOrderResponse> mapOrdersResponse(final List<Order> orders);

    Order mapCreateOrderRequest(final CreateOrderRequest createOrderRequest);

    CreateOrderResponse mapCreateOrderEntity(final Order order);
}
