package com.example.shop.express.reposervice;

import com.example.shop.express.entity.Order;
import com.example.shop.express.entity.OrderItem;
import com.example.shop.express.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemRepoService {

    @Autowired
    OrderItemRepository orderItemRepository;

    public OrderItem saveOrder(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

}
