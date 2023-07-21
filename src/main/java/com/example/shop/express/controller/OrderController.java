package com.example.shop.express.controller;

import com.example.shop.express.model.request.order.CreateOrderRequest;
import com.example.shop.express.model.request.order.FetchOrdersRequest;
import com.example.shop.express.model.request.order.UpdateOrderStatusRequest;
import com.example.shop.express.model.response.order.UpdateOrderStatusResponse;
import com.example.shop.express.model.response.order.CreateOrderResponse;
import com.example.shop.express.model.response.order.FetchOrderResponse;
import com.example.shop.express.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/orders")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @PostMapping
    public CreateOrderResponse createOrder(@Valid @RequestBody final CreateOrderRequest createOrderRequest){
        return orderService.createOrder(createOrderRequest);
    }

    @PutMapping
    public UpdateOrderStatusResponse updateOrder(@RequestBody final UpdateOrderStatusRequest updateOrderRequest){
        return orderService.updateOrderStatus(updateOrderRequest);
    }

    @GetMapping
    public List<FetchOrderResponse> fetchOrders(@Valid @RequestParam(value = "id", required = true) final Integer id) {
        FetchOrdersRequest fetchOrdersRequest = FetchOrdersRequest.builder().id(id).build();
        return orderService.fetchOrders(fetchOrdersRequest);
    }

}
