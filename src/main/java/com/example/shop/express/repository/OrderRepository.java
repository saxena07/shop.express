package com.example.shop.express.repository;

import com.example.shop.express.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query(value = "SELECT * from orders WHERE user_id=:id", nativeQuery = true)
    List<Order> fetchOrders(final Integer id);
}
