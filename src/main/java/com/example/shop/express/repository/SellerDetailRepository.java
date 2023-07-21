package com.example.shop.express.repository;

import com.example.shop.express.entity.SellerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerDetailRepository extends JpaRepository<SellerDetail,Integer> {
}
