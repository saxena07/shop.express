package com.example.shop.express.service.impl;

import com.example.shop.express.entity.Order;
import com.example.shop.express.entity.OrderItem;
import com.example.shop.express.mapper.OrderMapper;
import com.example.shop.express.model.request.order.CreateOrderRequest;
import com.example.shop.express.model.request.order.FetchOrdersRequest;
import com.example.shop.express.model.response.CreateOrderResponse;
import com.example.shop.express.model.response.order.FetchOrderResponse;
import com.example.shop.express.reposervice.OrderItemRepoService;
import com.example.shop.express.reposervice.OrderRepoService;
import com.example.shop.express.reposervice.ProductRepoService;
import com.example.shop.express.reposervice.SellerProductRepoService;
import com.example.shop.express.reposervice.UserRepoService;
import com.example.shop.express.service.IOrderService;
import org.aspectj.weaver.ast.Or;
import org.hibernate.type.OrderedMapType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderRepoService orderRepoService;

    @Autowired
    OrderItemRepoService orderItemRepoService;

    @Autowired
    UserRepoService userRepoService;

    @Autowired
    SellerProductRepoService sellerProductRepoService;

    @Autowired
    ProductRepoService productRepoService;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<FetchOrderResponse> fetchOrders(final FetchOrdersRequest fetchOrdersRequest) {
        List<Order> orders = orderRepoService.fetchOrders(fetchOrdersRequest.getId());
        return orderMapper.mapOrdersResponse(orders);
    }

    @Override
    public CreateOrderResponse createOrder(final CreateOrderRequest createOrderRequest) {

        Order order = orderMapper.mapCreateOrderRequest(createOrderRequest);
        order.setUser(userRepoService.getDetails(createOrderRequest.getUserId()));
        order.setShipment(shipmentRepoService.fetchShipment(createOrderRequest.getShipmentId()));

        List<OrderItem> orderItems = createOrderRequest.getOrderItems();

        for(OrderItem orderItem : orderItems){
            if(orderItem.getQuantity() > sellerProductRepoService.fetchQuantity(orderItem.getProduct().getId())){
                continue;
            }else{
                /// throw exception;
            }
        }

        //  create order
        for(OrderItem orderItem : orderItems){
            orderItem.setProduct(productRepoService.fetchProduct(orderItem.getProduct().getId()));
                orderItemRepoService.saveOrder(orderItem);
                sellerProductRepoService.updateQuantity(orderItem.getProduct().getId(), orderItem.getQuantity());
        }

        order = orderRepoService.saveOrder(order);

        return orderMapper.mapCreateOrderEntity(order);
    }
}
