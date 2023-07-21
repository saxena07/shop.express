package com.example.shop.express.mapper;


import com.example.shop.express.entity.Order;
import com.example.shop.express.model.request.order.CreateOrderRequest;
import com.example.shop.express.model.response.order.CreateOrderResponse;
import com.example.shop.express.model.response.order.FetchOrderResponse;
import com.example.shop.express.reposervice.UserRepoService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {
        UserRepoService.class})
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);


    List<FetchOrderResponse> mapOrdersResponse(final List<Order> orders);

    @Mapping(source = "userId", target = "user", qualifiedByName = "getUser")
    Order mapCreateOrderRequest(final CreateOrderRequest createOrderRequest);

    CreateOrderResponse mapCreateOrderEntity(final Order order);
}
