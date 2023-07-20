package com.example.shop.express.repository;

import com.example.shop.express.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>,
        JpaSpecificationExecutor<Category> {

    @Query(value = "SELECT C.* from categories C where C.id=:id", nativeQuery = true)
    Category fetchCategory(Integer id);

    @Query(value = "SELECT C.* from categories C", nativeQuery = true)
    List<Category> fetchCategories();
}
