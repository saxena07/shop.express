package com.example.shop.express.service.impl;

import com.example.shop.express.entity.Category;
import com.example.shop.express.entity.Product;
import com.example.shop.express.mapper.ProductMapper;
import com.example.shop.express.model.request.product.AddProductRequest;
import com.example.shop.express.model.response.product.AddProductResponse;
import com.example.shop.express.reposervice.CategoryRepoService;
import com.example.shop.express.reposervice.ProductRepoService;
import com.example.shop.express.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepoService productRepoService;

    @Autowired
    CategoryRepoService categoryRepoService;

    @Autowired
    ProductMapper productMapper;

    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
        Category category = categoryRepoService.fetchCategory(addProductRequest.getCategoryId());
        Product product = productMapper.mapProductRequest(addProductRequest);
        product.setCategory(category);
        product = productRepoService.saveProduct(product);
        return productMapper.mapProductEntity(product);
    }

}
