package com.example.shop.express.service;

import com.example.shop.express.model.request.order.CreateOrderRequest;
import com.example.shop.express.model.request.order.FetchOrdersRequest;
import com.example.shop.express.model.response.order.CreateOrderResponse;
import com.example.shop.express.model.response.order.FetchOrderResponse;

import java.util.List;

public interface IOrderService {
    List<FetchOrderResponse> fetchOrders(FetchOrdersRequest fetchOrdersRequest);

    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest);
}
