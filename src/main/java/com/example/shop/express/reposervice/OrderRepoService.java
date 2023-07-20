package com.example.shop.express.reposervice;

import com.example.shop.express.entity.Order;
import com.example.shop.express.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderRepoService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(final Order order)
    {
        return orderRepository.save(order);
    }

    public Order fetchOrderById(final  Integer id)
    {
        return orderRepository.getReferenceById(id);
    }

    public List<Order> fetchOrders(Integer id) {
        return orderRepository.findAll();
    }
}
