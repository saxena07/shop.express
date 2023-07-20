package com.example.shop.express.reposervice;

import com.example.shop.express.entity.Product;
import com.example.shop.express.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductRepoService {

    @Autowired
    ProductRepository productRepository;


    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
