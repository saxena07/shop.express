package com.example.shop.express.service.impl;

import com.example.shop.express.constant.Constant;
import com.example.shop.express.entity.Order;
import com.example.shop.express.entity.OrderItem;
import com.example.shop.express.entity.SellerProduct;
import com.example.shop.express.entity.Shipment;
import com.example.shop.express.exception.InvalidActionException;
import com.example.shop.express.mapper.OrderItemMapper;
import com.example.shop.express.mapper.OrderMapper;
import com.example.shop.express.model.request.order.CreateOrderRequest;
import com.example.shop.express.model.request.order.FetchOrdersRequest;
import com.example.shop.express.model.request.orderItem.OrderItemRequest;
import com.example.shop.express.model.response.order.CreateOrderResponse;
import com.example.shop.express.model.response.order.FetchOrderResponse;
import com.example.shop.express.reposervice.OrderItemRepoService;
import com.example.shop.express.reposervice.OrderRepoService;
import com.example.shop.express.reposervice.ProductRepoService;
import com.example.shop.express.reposervice.SellerProductRepoService;
import com.example.shop.express.reposervice.ShipmentRepoService;
import com.example.shop.express.reposervice.UserRepoService;
import com.example.shop.express.repository.SellerProductRepository;
import com.example.shop.express.service.IOrderService;
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
    ShipmentRepoService shipmentRepoService;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    public List<FetchOrderResponse> fetchOrders(final FetchOrdersRequest fetchOrdersRequest) {
        List<Order> orders = orderRepoService.fetchOrders(fetchOrdersRequest.getId());
        return orderMapper.mapOrdersResponse(orders);
    }

    @Override
    public CreateOrderResponse createOrder(final CreateOrderRequest createOrderRequest) {

        Order order = orderMapper.mapCreateOrderRequest(createOrderRequest);
//        order.setUser(userRepoService.getDetails(createOrderRequest.getUserId()));
//        order.setShipment(shipmentRepoService.fetchShipment(createOrderRequest.getShipmentId()));
        List<OrderItemRequest> orderItems = createOrderRequest.getOrderItems();

        for (OrderItemRequest orderItemRequest : orderItems) {
            if (orderItemRequest.getQuantity() < sellerProductRepoService.fetchQuantity(
                    orderItemRequest.getProductId())) {
                continue;
            } else {
                throw new InvalidActionException(Constant.CANT_PLACE_ORDER);
            }
        }
        order = orderRepoService.saveOrder(order);
        //  create order
        for (OrderItemRequest orderItemRequest : orderItems) {
            OrderItem orderItem = orderItemMapper.mapOrderItemRequest(orderItemRequest);
            orderItem.setProduct(productRepoService.fetchProduct(orderItemRequest.getProductId()));
            orderItem.setOrder(order);
            orderItem.setSellerProduct(sellerProductRepoService.fetchSellerProduct(
                    orderItemRequest.getSellerProductId()));
            orderItemRepoService.saveOrder(orderItem);
            SellerProduct sellerProduct =
                    sellerProductRepoService.updateQuantity(orderItemRequest.getSellerProductId(),
                            orderItemRequest.getProductId(), orderItem.getQuantity());
            System.out.println(sellerProduct);
        }
        return orderMapper.mapCreateOrderEntity(order);
    }
}
