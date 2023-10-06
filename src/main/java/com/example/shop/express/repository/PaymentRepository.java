package com.example.shop.express.repository;

import com.example.shop.express.entity.Order;
import com.example.shop.express.entity.Payment;
import com.example.shop.express.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {


//    public Payment fetchPaymentByOrderAndUser(final Integer userId,final Integer orderId)
//    {
//
//    }


    Optional<Payment> findPaymentByOrder_IdAndUser_Id(Integer order_id, Integer user_id);
}
