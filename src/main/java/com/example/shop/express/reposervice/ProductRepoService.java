package com.example.shop.express.reposervice;

import com.example.shop.express.entity.Product;
import com.example.shop.express.enums.ProductCategory;
import com.example.shop.express.model.response.product.FetchProductResponse;
import com.example.shop.express.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.Condition;

@Service
public class ProductRepoService {

    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> fetchProducts(Integer id, String name, Integer categoryId,
                                       String categoryName) {
        Integer categoryOrdinal;
        if (categoryName == null) {
            categoryOrdinal = null;
        } else {
            categoryOrdinal = ProductCategory.valueOf(categoryName).ordinal();
        }
        return productRepository.fetchProducts(id, name, categoryId, categoryOrdinal);
    }

    public Product fetchProduct(final Integer id) {
        return productRepository.fetchProduct(id);
    }
}
