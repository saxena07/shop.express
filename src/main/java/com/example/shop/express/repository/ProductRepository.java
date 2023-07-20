package com.example.shop.express.repository;

import com.example.shop.express.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

//    Product save(final Product product);

    @Query(value = "SELECT P.* FROM products P where (:id IS NULL OR P"
                   + ".id=:id) AND (:name IS NULL OR P.name=:name) AND (:categoryId IS NULL OR P"
                   + ".category_id=:categoryId)", nativeQuery = true)
    List<Product> fetchProducts(Integer id, String name, Integer categoryId);

    @Query(value = "SELECT P.* FROM products P WHERE P.id=:id", nativeQuery = true)
    Product fetchProduct(Integer id);
}
