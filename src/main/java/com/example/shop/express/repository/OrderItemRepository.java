package com.example.shop.express.repository;

import com.example.shop.express.entity.OrderItem;
import com.example.shop.express.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository   extends JpaRepository<OrderItem, Integer>,
        JpaSpecificationExecutor<OrderItem> {
}
