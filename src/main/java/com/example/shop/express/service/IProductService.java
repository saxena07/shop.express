package com.example.shop.express.service;

import com.example.shop.express.model.request.product.AddProductRequest;
import com.example.shop.express.model.response.product.AddProductResponse;

public interface IProductService {

    AddProductResponse addProduct(AddProductRequest addProductRequest);
}
