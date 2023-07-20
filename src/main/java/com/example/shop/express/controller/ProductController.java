package com.example.shop.express.controller;

import com.example.shop.express.model.request.product.AddProductRequest;
import com.example.shop.express.model.response.product.AddProductResponse;
import com.example.shop.express.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/product")
@RestController
public class ProductController {

    @Autowired
    IProductService addProductService;

    @PostMapping
    public AddProductResponse addProduct(@RequestBody final AddProductRequest addProductRequest) {
        return addProductService.addProduct(addProductRequest);
    }

}
