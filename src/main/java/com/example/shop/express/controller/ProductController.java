package com.example.shop.express.controller;

import com.example.shop.express.model.request.product.AddProductRequest;
import com.example.shop.express.model.request.product.FetchProductRequest;
import com.example.shop.express.model.request.product.FetchProductsRequest;
import com.example.shop.express.model.response.product.AddProductResponse;
import com.example.shop.express.model.response.product.FetchProductResponse;
import com.example.shop.express.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "api/v1/products")
@RestController
public class ProductController {

    @Autowired
    IProductService productService;

    // check seller
    @PostMapping
    public AddProductResponse addProduct(@RequestBody final AddProductRequest addProductRequest) {
        return productService.addProduct(addProductRequest);
    }

    @GetMapping(value = "/details")
    public FetchProductResponse fetchProduct(
            @RequestParam(value = "id", required = true) final Integer id) {
        FetchProductRequest fetchProductRequest = FetchProductRequest.builder().id(id).build();
        return productService.fetchProduct(fetchProductRequest);
    }

    @GetMapping
    public List<FetchProductResponse> fetchProducts(
            @RequestParam(value = "id", required = false) final Integer id,
            @RequestParam(value = "name", required = false) final String name,
            @RequestParam(value = "category", required = false) final Integer categoryId
            ) {
        FetchProductsRequest fetchProductsRequest =
                FetchProductsRequest.builder().id(id).name(name).categoryId(categoryId).build();
        return productService.fetchProducts(fetchProductsRequest);
    }

}
