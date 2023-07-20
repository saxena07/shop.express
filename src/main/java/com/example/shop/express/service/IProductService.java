package com.example.shop.express.service;

import com.example.shop.express.model.request.product.AddProductRequest;
import com.example.shop.express.model.request.product.FetchProductRequest;
import com.example.shop.express.model.request.product.FetchProductsRequest;
import com.example.shop.express.model.response.product.AddProductResponse;
import com.example.shop.express.model.response.product.FetchProductResponse;

import java.util.List;

public interface IProductService {

    AddProductResponse addProduct(final AddProductRequest addProductRequest);

    List<FetchProductResponse> fetchProducts(final FetchProductsRequest fetchProductsRequest);

    FetchProductResponse fetchProduct(final FetchProductRequest fetchProductRequest);
}
