package com.example.shop.express.repository;

import com.example.shop.express.entity.SellerProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerProductRepository
        extends JpaRepository<SellerProduct, Integer>, JpaSpecificationExecutor<SellerProduct> {

    @Query(value = "SELECT CASE WHEN COUNT(S.*) > 0 THEN 1 ELSE 0 END AS id_present"
                   + "FROM seller_product S WHERE id = :id", nativeQuery = true)
    Boolean checkSeller(Integer id);

    @Query(value = "Select quantity from seller_product where product_id=:id", nativeQuery = true)
    Integer fetchQuantity(Integer id);

}
