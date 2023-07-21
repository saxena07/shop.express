package com.example.shop.express.service.impl;

import com.example.shop.express.constant.Constant;
import com.example.shop.express.entity.Order;
import com.example.shop.express.entity.OrderItem;
import com.example.shop.express.entity.Payment;
import com.example.shop.express.entity.SellerProduct;
import com.example.shop.express.entity.User;
import com.example.shop.express.exception.InvalidActionException;
import com.example.shop.express.mapper.OrderItemMapper;
import com.example.shop.express.mapper.OrderMapper;
import com.example.shop.express.mapper.PaymentMapper;
import com.example.shop.express.model.request.order.CreateOrderRequest;
import com.example.shop.express.model.request.order.FetchOrdersRequest;
import com.example.shop.express.model.request.order.UpdateOrderStatusRequest;
import com.example.shop.express.model.request.orderItem.OrderItemRequest;
import com.example.shop.express.model.response.order.CreateOrderResponse;
import com.example.shop.express.model.response.order.FetchOrderResponse;
import com.example.shop.express.model.response.order.UpdateOrderStatusResponse;
import com.example.shop.express.reposervice.OrderItemRepoService;
import com.example.shop.express.reposervice.OrderRepoService;
import com.example.shop.express.reposervice.PaymentRepoService;
import com.example.shop.express.reposervice.ProductRepoService;
import com.example.shop.express.reposervice.SellerProductRepoService;
import com.example.shop.express.reposervice.ShipmentRepoService;
import com.example.shop.express.reposervice.UserRepoService;
import com.example.shop.express.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    PaymentRepoService paymentRepoService;

    @Autowired
    PaymentMapper paymentMapper;


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
        Payment payment=generatePayment(order, order.getUser());
        order.setPayment(new ArrayList<>());
        order.getPayment().add(payment);

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

    @Override
    public UpdateOrderStatusResponse updateOrderStatus(UpdateOrderStatusRequest updateOrderRequest) {
        Order order = orderRepoService.updateOrderStatus(updateOrderRequest.getId(),
                updateOrderRequest.getStatus());
        UpdateOrderStatusResponse updateOrderStatusResponse =
                orderMapper.mapUpdateOrderStatusEntity(order);
        updateOrderStatusResponse.setDescription(Constant.ORDER_UPDATED_SUCCESSFULLY);
        return updateOrderStatusResponse;
    }

    private Payment generatePayment(final Order order, final User user) {

        return paymentRepoService.CreateOrUpdatePayment(
                Payment.builder().user(user).order(order).amount(order.getTotalAmount()).build());
    }
}
