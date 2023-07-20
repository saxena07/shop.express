package com.example.shop.express.controller;

import com.example.shop.express.model.request.category.FetchCategoryRequest;
import com.example.shop.express.model.request.category.AddCategoryRequest;
import com.example.shop.express.model.response.category.FetchCategoryResponse;
import com.example.shop.express.model.response.category.AddCategoryResponse;
import com.example.shop.express.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @GetMapping
    public FetchCategoryResponse fetchCategory(@RequestParam(name = "id", required = true) final Integer id){
        FetchCategoryRequest fetchCategoryRequest = FetchCategoryRequest.builder().id(id).build();
        return categoryService.fetchCategory(fetchCategoryRequest);
    }

    @PostMapping
    public AddCategoryResponse addCategory(
            @RequestBody final AddCategoryRequest addCategoryRequest) {
        return categoryService.addCategory(addCategoryRequest);
    }
}
